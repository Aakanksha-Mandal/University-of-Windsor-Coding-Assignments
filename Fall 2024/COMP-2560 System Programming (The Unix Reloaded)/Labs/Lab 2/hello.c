#include <stdio.h>
#include <time.h>
#include <stdlib.h>
int main()
{
  printf("Hello World! This is mandal5@uwindsor.ca, StudentID: 110189000\n");
  time_t t = time(NULL);
  struct tm tm = *localtime(&t);
  printf("now: %d-%02d-%02d %02d:%02d:%02d\n", tm.tm_year + 1900, tm.tm_mon + 1, tm.tm_mday, tm.tm_hour, tm.tm_min, tm.tm_sec);
  printf("%s@shell:%s$\n", getenv("USER"),getenv("PWD"));

}
//int main(void){
//	printf("Hello World!\n");
//	return 0;
//}
