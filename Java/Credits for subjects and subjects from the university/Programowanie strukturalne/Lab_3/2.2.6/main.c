#include <stdio.h>
#include <stdlib.h>
int potega(int n, int m){
    if(m == 0){
        return 1;
    }
    return potega(n,m-1)*n;
}
int main()
{
    printf("Hello world!\n");
    return 0;
}
