#include <stdio.h>
#include <stdlib.h>
void foo(int *tab){
    free(tab);
}
int main()
{
    int *tab = (int) malloc(sizeof(int) * 4);
    foo(tab);
    return 0;
}
