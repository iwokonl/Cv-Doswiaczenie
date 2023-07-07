#include <stdio.h>
#include <stdlib.h>
void a_zad_bez_wsk(int n, int tab1[], int tab2[], double tab3[]){
    for(int i = 0;i<n;i++){
        tab3[i] = (double) tab1[i];
    }
    for(int i = n;i<n*2;i++){
        tab3[i] = (double) tab2[(i-n)];
    }
}

void a_zad_z_wsk(int n, int *tab1, int *tab2, double *tab3){
        for(int i = 0;i<n;i++){
        *tab3 = (double) *tab1;
    }
    for(int i = n;i<n*2;i++){
        *tab3 = (double) *tab2;
    }
}
void b_zad_bez_wsk(int n, int tab1[], int tab2[], double tab3[]){
    for(int i = 0;i<n*2;i++){
        if(i%2==0){
            tab3[i] = (double) tab2[i/2];
        }if(i%2==1){
            tab3[i] = (double) tab1[(i-1)/2];
        }
    }
}

void b_zad_z_wsk(int n, int *tab1, int *tab2, double *tab3){
    for(int i = 0;i<n*2;i++){
        if(i%2==0){
            *tab3 = (double) *tab2;
            tab2++;
        }if(i%2==1){
            *tab3 = (double) *tab1;
            tab1++;
        }
    }
}

void wyswietl_bez_wsk(int size, double tab[]){
    for(int i = 0;i<size;i++){
        printf("%lf\n", tab[i]);
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
    double tab3[] = {0,0,0,0,0,0,0,0};
    int tab2[] = {1,3,5,7};
    int tab1[] = {2,4,6,8};
    b_zad_bez_wsk(4,tab1,tab2,tab3);
    wyswietl_bez_wsk(8,tab3);
    return 0;
}
