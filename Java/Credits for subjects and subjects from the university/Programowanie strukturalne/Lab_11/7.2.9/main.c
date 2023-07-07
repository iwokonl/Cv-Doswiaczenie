#include <stdio.h>
#include <stdlib.h>
struct lista{
    int liczba;
    int *liczba2;

};
void wys_wspol(struct lista *o1){

    printf("Wartoœci: %d, %d", o1->liczba, *o1->liczba2);
    printf("adres: %p, %p", o1->liczba, *o1->liczba2);
}
int main()
{
    int liczba = 2;
    struct lista o1 = {liczba, &liczba};
    wys_wspol(&o1);
    //printf("Hello world!\n");
    return 0;
}
