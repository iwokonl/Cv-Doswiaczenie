#include <stdio.h>
#include <stdlib.h>
double* zarezerwuj(){
    double* i = (double *) malloc(sizeof(double));
    printf("%p\n", i);
    return i;

}
int main()
{
    double* x = zarezerwuj();
    printf("%p", x);
    return 0;
}
