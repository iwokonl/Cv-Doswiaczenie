#include <stdio.h>
#include <stdlib.h>
double* zarezerwuj(int n){
    double* i = (double *) malloc(sizeof(double)*n);
    printf("%p\n", i);
    return i;

}
int main()
{
    double* x = zarezerwuj(4);
    printf("%p", x);
    return 0;
}
