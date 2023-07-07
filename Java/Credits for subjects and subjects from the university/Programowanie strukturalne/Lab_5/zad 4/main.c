#include <stdio.h>
#include <stdlib.h>
int foo(const int *wsk, int *const wsk2){
    return *wsk - *wsk2;
}


int main()
{
    int x = 4;
    int y = 5;
    printf("%d\n", foo(&x,&y));
    return 0;
}
