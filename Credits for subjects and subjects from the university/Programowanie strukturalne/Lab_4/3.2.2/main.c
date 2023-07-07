#include <stdio.h>
#include <stdlib.h>
int mniejsza(int *x,int *y){
    if(*x<*y){
        return *y;
    }
    return *x;

}
int main()
{
    int x=3;
    int y=2;
    printf("%d", mniejsza(&x,&y));
    return 0;
}
