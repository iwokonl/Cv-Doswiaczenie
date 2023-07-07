#include <stdio.h>
#include <stdlib.h>
void zamiana(int *x,int *y){
    if(*x>*y){
    int temp = *x;
    *x = *y;
    *y = temp;
    }
}
int main()
{
    int x=3;
    int y=2;
    zamiana(&x,&y);
    printf("%d\n",x);
    printf("%d\n",y);
    return 0;
}
