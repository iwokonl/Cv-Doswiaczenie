#include <stdio.h>
#include <stdlib.h>
int suma(const int *x, const int *y){
    int temp = *x + *y;

    return temp;
}
int main()
{
    int x=3;
    int y=2;
    printf("%d",suma(&x,&y));
    return 0;
}
