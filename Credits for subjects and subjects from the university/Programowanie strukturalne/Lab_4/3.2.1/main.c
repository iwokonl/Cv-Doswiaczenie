#include <stdio.h>
#include <stdlib.h>
int wieksza(int *x,int *y){
    if(*x>*y){
        return *x;
    }
    return *y;
}
int main()
{
    int x=2;
    int y=3;
    printf("%d", wieksza(&x,&y));
    return 0;
}
