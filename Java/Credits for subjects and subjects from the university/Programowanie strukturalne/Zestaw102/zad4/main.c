#include <stdio.h>
#include <stdlib.h>
int foo(int n){
    if(n == 0)
        return 4;
    return foo(n - 1) * 3 * - 1;
}
int main()
{
    printf("%d", foo(2));
    return 0;
}
