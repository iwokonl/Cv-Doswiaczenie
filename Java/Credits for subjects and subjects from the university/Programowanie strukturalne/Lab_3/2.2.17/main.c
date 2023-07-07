#include <stdio.h>
#include <stdlib.h>
int liczba = 0;
void foo(){
    liczba++;
}
int main()
{
    printf("%d\n", liczba);
    foo();
    foo();
    foo();
    foo();
    printf("%d\n", liczba);
    return 0;
}
