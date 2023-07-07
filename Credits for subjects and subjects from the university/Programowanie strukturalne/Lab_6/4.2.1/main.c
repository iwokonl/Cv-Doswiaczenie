#include <stdio.h>
#include <stdlib.h>
void a_zad_bez_wsk(int size, int tab[]){
    for(int i = 0;i<size;i++){
        tab[i]=0;
    }
}

void a_zad_z_wsk(int size, int *tab){
    for(int i = 0;i<size;i++){
        *tab = 0;
        tab++;
    }
}

void b_zad_bez_wsk(int size, int tab[]){
    for(int i = 0;i<size;i++){
        tab[i] = i;
    }
}

void b_zad_z_wsk(int size, int *tab){
    for(int i = 0;i<size;i++){
        *tab = i;
        tab++;
    }
}

void c_zad_bez_wsk(int size, int tab[]){
    for(int i = 0;i<size;i++){
        tab[i] *= 2;
    }
}

void c_zad_z_wsk(int size, int *tab){
    for(int i = 0;i<size;i++){
        *tab *= 2;
        tab++;
    }
}

void d_zad_bez_wsk(int size, int tab[]){
    for(int i = 0;i<size;i++){
        if(tab[i] < 0){
            tab[i] = tab[i] * -1;
        }
    }
}

void d_zad_z_wsk(int size, int *tab){
    for(int i = 0;i<size;i++){
        if(*tab < 0){
            *tab = *tab * -1;
        }
        tab++;
    }
}

void wyswietl_bez_wsk(int size, int tab[]){
    for(int i = 0;i<size;i++){
        printf("%d\n", tab[i]);
    }
}
void wyswietl_z_wsk(int size, int *tab){
    for(int i = 0;i<size;i++){
        printf("%d\n", *tab);
        tab++;
    }
}

int main()
{
    int tab_bez_wsk[] = {-1,2,-3,4};
    int sizee = 4;

    int *tab_z_wsk = malloc(sizeof(int)*4);
    *(tab_z_wsk + 0) = -1;
    *(tab_z_wsk + 1) = 2;
    *(tab_z_wsk + 2) = -3;
    *(tab_z_wsk + 3)= 4;
    wyswietl_z_wsk(sizee,tab_z_wsk);
    d_zad_z_wsk(sizee,tab_z_wsk);
    wyswietl_z_wsk(sizee,tab_z_wsk);
    return 0;
}
