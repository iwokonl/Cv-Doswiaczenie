#include <stdio.h>
#include <stdlib.h>
int dodaj(int a,int b){
    return a+b;
}
int odejmij(int a,int b){
    return a-b;
}
int main()
{
    int (*wsk)(int,int);
    wsk = dodaj;
    printf("%d", wsk(3,4));
    wsk = odejmij;
    printf("%d", wsk(3,4));
    return 0;
}
