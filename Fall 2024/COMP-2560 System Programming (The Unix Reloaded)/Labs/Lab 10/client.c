#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <unistd.h>

int is_valid_integer(const char *str) {
    if (*str == '\0') return 0;
    if (*str == '-' || *str == '+') str++;

    while (*str) {
        if (!isdigit(*str)) return 0;
        str++;
    }
    return 1;
}

int main(int argc, char *argv[]) {
    if (argc != 3) {
        fprintf(stderr, "Usage: %s <IP> <PORT>\n", argv[0]);
        return 1;
    }

    int client_sd = socket(AF_INET, SOCK_STREAM, 0);
    if (client_sd == -1) {
        perror("error creating socket");
        return 1;
    }

    struct sockaddr_in server_sin;
    server_sin.sin_family = AF_INET;
    server_sin.sin_port = htons(atoi(argv[2]));
    inet_pton(AF_INET, argv[1], &server_sin.sin_addr);

    if (connect(client_sd, (struct sockaddr *) &server_sin, sizeof(server_sin)) == -1) {
        perror("error connecting to the server");
        close(client_sd);
        return 1;
    }

    // Get client's local IP address and port
    struct sockaddr_in client_addr;
    socklen_t addr_len = sizeof(client_addr);
    if (getsockname(client_sd, (struct sockaddr *)&client_addr, &addr_len) == -1) {
        perror("error getting local address");
        close(client_sd);
        return 1;
    }

    // Display client’s local IP address and port
    char local_ip[INET_ADDRSTRLEN];
    inet_ntop(AF_INET, &client_addr.sin_addr, local_ip, sizeof(local_ip));
    printf("Client is connected to the server at %s:%d\n", local_ip, ntohs(client_addr.sin_port));

    char x_str[20], y_str[20];
    int x, y;
    char username[50], password[50];
    char buffer[1024];

    while (1) {
        printf("Enter two numbers (or -1 for both to quit): \n");
        
        while (1) {
            printf("Enter x: ");
            fgets(x_str, sizeof(x_str), stdin);
            x_str[strcspn(x_str, "\n")] = '\0';
            if (is_valid_integer(x_str)) break;
            printf("Invalid input. Please enter an integer for x.\n\n");
        }

        while (1) {
            printf("Enter y: ");
            fgets(y_str, sizeof(y_str), stdin);
            y_str[strcspn(y_str, "\n")] = '\0';
            if (is_valid_integer(y_str)) break;
            printf("Invalid input. Please enter an integer for y.\n\n");
        }

        x = atoi(x_str);
        y = atoi(y_str);

        if (x == -1 && y == -1) {
            printf("Exiting...\n");
            break;
        }

        printf("Enter username: ");
        fgets(username, sizeof(username), stdin);
        username[strcspn(username, "\n")] = '\0';

        printf("Enter password: ");
        fgets(password, sizeof(password), stdin);
        password[strcspn(password, "\n")] = '\0';

        // Format message with comma separation
        snprintf(buffer, sizeof(buffer), "%s,%s,%d,%d", username, password, x, y);
        send(client_sd, buffer, strlen(buffer), 0);

        int bytes_received = recv(client_sd, buffer, sizeof(buffer) - 1, 0);
        if (bytes_received > 0) {
            buffer[bytes_received] = '\0';
            printf("Server response: %s\n", buffer);
        } else {
            printf("Failed to receive response from server.\n");
            break;
        }
    }

    close(client_sd);
    return 0;
}