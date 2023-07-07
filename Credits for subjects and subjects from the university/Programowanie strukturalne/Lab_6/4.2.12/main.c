#include <stdio.h>
#include <stdlib.h>
void a_zad_bez_wsk(int n, int tab[]){
    int temp;
    for(int i = 0; i<n/2; i++){
        temp = tab[i];
        tab[i] = tab[n-i-1];
        tab[n-i-1] = temp;
    }
}

void a_zad_z_wsk(int n, int tab[]){
    int temp;
    for(int i = 0; i<n/2; i++){
        temp = *(tab+i);
        *(tab+i) = *(tab + (n-i-1));
        *(tab + (n-i-1)) = temp;
    }
}

void b_zad_bez_wsk(int n, int tab[]){
    int temp = tab[0];
    for(int i = 1; i<n; i++){
        tab[i-1] = tab[i];
    }
    tab[n-1] = temp;
}

void b_zad_z_wsk(int n, int tab[]){
    int temp = *tab;
    tab++;
    for(int i = 1; i<n; i++){
        *(tab + i-1) = *(tab + i);
    }
    *(tab + n-1) = temp;
}

void c_zad_bez_wsk(int n, int tab[]){
    int temp = tab[n-1];
    for(int i = n-1; i>0 ; i--){
        tab[i] = tab[i-1];
    }
    tab[0] = temp;
}

void c_zad_z_wsk(int n, int tab[]){
    int temp = *(tab + n - 1);
    for(int i = n-1; i>0 ; i--){
        *(tab + i) = *(tab + i-1);
    }
    *(tab + 0) = temp;
}

void d_zad_bez_wsk(int tab[], int n){
    int temp = 0;
    for (int i = 0; i < n; ++i)
    {
        for (int j = i + 1; j < n; ++j)
        {
            if (tab[i] > tab[j])
            {
                temp =  tab[i];
                tab[i] = tab[j];
                tab[j] = temp;
            }
        }
    }
}

void d_zad_z_wsk(int n, int tab[]){
    int temp = 0;
    for (int i = 0; i < n; ++i)
    {
        for (int j = i + 1; j < n; ++j)
        {
            if (*(tab + i) > *(tab + j))
            {
                temp =  *(tab + i);
                *(tab + i) = *(tab + j);
                *(tab + j) = temp;
            }
        }
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
    int tab[] = {4,3,2,1};
    d_zad_bez_wsk(tab,4);
    wyswietl_bez_wsk(4,tab);
    return 0;
}
