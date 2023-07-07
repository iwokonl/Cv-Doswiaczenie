#include <stdio.h>
#include <stdlib.h>
void foo(const int *x, int *y){
    *y = *x;

}
int main()
{
    int x = 3;
    int y = 2;
    foo(&x,&y);
    printf("%d\n", x);
    printf("%d", y);
    return 0;
}
