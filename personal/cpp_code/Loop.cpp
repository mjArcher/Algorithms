#include <stdio.h>

int main() {
  int c;
  for (c = 0; c < 100; ++c) {
    printf("%d\t%c\n", c, c);
    for (c = 0; c < 100; ++c) {
      printf("%d\t%c\n", c, c);
      for (c = 0; c < 100; ++c) {
        printf("%d\t%c\n", c, c);
      }
    }
  }

  c = 0;
  for (c = 0; c < 100; ++c)
    printf("%d\t%c", c, c);
  for (c = 0; c < 100; ++c)
    printf("%d\t%c", c, c);
  for (c = 0; c < 100; ++c)
    printf("%d\t%c", c, c);


  return 0;
}
