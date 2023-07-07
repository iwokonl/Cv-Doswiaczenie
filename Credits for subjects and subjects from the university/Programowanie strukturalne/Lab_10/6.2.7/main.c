#include <stdio.h>
#include <stdlib.h>
int **foo(int n){
    int **tab = malloc(sizeof(int*)*n);
    for(int i = 1;i<=n;i++){
        *(tab+i-1) = malloc(sizeof(int)*i);
    }
    return tab;
}
int main()
{
    int temp = foo(5);
    return 0;
}
