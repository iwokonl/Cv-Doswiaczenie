#include <stdio.h>
#include <stdlib.h>
double* foo(int n){
    double *tab = (double*) malloc(sizeof(double) * n);
    if(tab == NULL){
        return NULL;
    }
    return tab;
}
int main()
{
    double *wsk = foo(7);
    printf("%d",sizeof(wsk));
    return 0;
}
