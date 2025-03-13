#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <unistd.h>
#include <arpa/inet.h>
#include <sys/socket.h>

#define USERNAME "comp2560"
#define PASSWORD "f2022"

int main(int argc, char *argv[]) {
    if (argc != 3) {
        fprintf(stderr, "Usage: %s <IP> <PORT>\n", argv[0]);
        return 1;
    }

    int server_sd = socket(AF_INET, SOCK_STREAM, 0);
    if (server_sd == -1) {
        perror("error creating socket");
        return 1;
    }

    struct sockaddr_in server_addr;
    server_addr.sin_family = AF_INET;
    server_addr.sin_port = htons(atoi(argv[2]));
    inet_pton(AF_INET, argv[1], &server_addr.sin_addr);

    if (bind(server_sd, (struct sockaddr *) &server_addr, sizeof(server_addr)) == -1) {
        perror("error binding socket");
        close(server_sd);
        return 1;
    }

    if (listen(server_sd, 5) < 0) {
        perror("error in listen");
        close(server_sd);
        return 1;
    }
    printf("Server listening on %s:%s\n", argv[1], argv[2]);

    struct sockaddr_in client_addr;
    socklen_t client_addr_len = sizeof(client_addr);
    char buffer[1024];

    while (1) {
        int client_sd = accept(server_sd, (struct sockaddr *) &client_addr, &client_addr_len);
        if (client_sd == -1) {
            perror("error accepting client");
            continue;
        }

        // Log client connection details
        printf("Client connected from %s:%d\n", inet_ntoa(client_addr.sin_addr), ntohs(client_addr.sin_port));

        if (fork() == 0) {
            close(server_sd);

            while (1) {
                int bytes_received = recv(client_sd, buffer, sizeof(buffer) - 1, 0);
                if (bytes_received <= 0) break;

                buffer[bytes_received] = '\0';

                // Split by commas
                char *username = strtok(buffer, ",");
                char *password = strtok(NULL, ",");
                char *x_str = strtok(NULL, ",");
                char *y_str = strtok(NULL, ",");

                if (!username || !password || !x_str || !y_str) {
                    snprintf(buffer, sizeof(buffer), "Error: Missing input fields.\n");
                    send(client_sd, buffer, strlen(buffer), 0);
                    continue;
                }

                int x = atoi(x_str);
                int y = atoi(y_str);

                if (strcmp(username, USERNAME) == 0 && strcmp(password, PASSWORD) == 0) {
                    int result = x + y;
                    snprintf(buffer, sizeof(buffer), "Result: %d + %d = %d\n", x, y, result);
                } else {
                    snprintf(buffer, sizeof(buffer), "Authentication failed!\n");
                }
                send(client_sd, buffer, strlen(buffer), 0);
            }

            close(client_sd);
            exit(0);
        }

        close(client_sd);
    }

    close(server_sd);
    return 0;
}