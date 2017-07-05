/*
* Prompt: What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
*
* Execute: gcc Problem05.c; ./a.out; rm a.out
*
* Answer: 232792560
*/
#include <stdio.h>

int main () {
  int i = 1;
  LOOP:while (1) {
    i++;
    for (int j = 20; j > 0; j--) {
      if (i % j != 0) {
        goto LOOP;
      }
      if (j == 1) {
        printf("%d\n", i);
        return 0;
      }
    }
  }
  return 1;
}
