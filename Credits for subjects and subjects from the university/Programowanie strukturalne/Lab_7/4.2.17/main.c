#include <stdio.h>
#include <stdlib.h>
double *foo(int n,double *tab){
    double *tab_copy = (double*) malloc(sizeof(double) * n);
    if(tab_copy == NULL){
        return NULL;
    }
    for(int i = 0;i<n;i++){
        *(tab_copy + i) = *(tab + i);
    }
    return tab_copy;
}
int main()
{
    int n = 4;
    double *wsk = malloc(sizeof(double)*n);
    *(wsk + 0) = 1;
    *(wsk + 1) = 2;
    *(wsk + 2) = 3;
    *(wsk + 3) = 4;
    double *wsk_temp = foo(n,wsk);
    for(int i = 0;i<n;i++){
        printf("%lf\n" , *wsk_temp);
        *wsk_temp++;
    }
    return 0;
}
