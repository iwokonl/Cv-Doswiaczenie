#include <stdio.h>
#include <stdlib.h>
void foo(int *temp1, int *temp2){
    if(*temp1 < *temp2){
        *temp1 = *temp2;
    }
    else if(*temp1 > *temp2){
        *temp2 = *temp1;
    }
}
int main()
{
    int x = 3;
    int y = 4;
    foo(&x,&y);
    printf("%d %d",x , y);
    return 0;
}
