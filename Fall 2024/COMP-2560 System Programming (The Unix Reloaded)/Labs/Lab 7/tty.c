#include <fcntl.h>
#include <unistd.h>

void main() {
	int fd_in = open("/dev/pts/14", O_RDONLY);
	
	if(fd_in == -1){
		write(STDOUT_FILENO, "Error in opening device!\n", 25);
		return;
	}

	int fd_out = open("log.txt", O_WRONLY | O_CREAT | O_TRUNC, 0664);

	if(fd_out == -1) {
		write(STDOUT_FILENO, "Error in opening log.txt!\n", 26);
		close(fd_in);
		return;
	} 

	char buf[20];
	ssize_t bytes_read;
	
	while ((bytes_read = read(fd_in, buf, sizeof(buf))) > 0) {
		if (bytes_read < sizeof(buf)) {
			buf[bytes_read] = '\0';  // Null-terminate the buffer for safety
		}

		if (bytes_read >= 3 && buf[0] == 'E' && buf[1] == 'N' && buf[2] == 'D') {
			write(1, "exiting...\n", 11);
			break;
		}

		write(fd_out, buf, bytes_read);
    	}
	
	if (bytes_read == -1) {
		write(1, "Error in reading from device!\n", 30);
	}

	if (close(fd_in) == -1) {
		write(1, "Error in closing the device!\n", 29);
	}

	if (close(fd_out) == -1) {
		write(1, "Error in closing the log file!\n", 31);
	}
}	
