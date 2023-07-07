#include <stdio.h>
#include <stdlib.h>
int *foo(int n, int *tab1){
    int temp = 0;
    for(int i = 0;i < n;i++){
        if(*(tab1 + i) != 0){
            temp++;
        }
    }
    temp = 0;
    int *tab2 = (int*) malloc(sizeof(int) * temp);
    if(tab2 == NULL){
        return NULL;
    }
    for(int i = 0;i < n;i++){
        if(*(tab1 + i) != 0){
            *(tab2 + temp)= *(tab1 + i);
            temp++;
        }
    }
    return tab2;
}
int main()
{
    int n = 5;
    int *tab1 = (int*) malloc(sizeof(int)*n);
    *(tab1 + 0) = 1;
    *(tab1 + 1) = 0;
    *(tab1 + 2) = 3;
    *(tab1 + 3) = 1;
    *(tab1 + 4) = 1;
    int *tab2 = foo(n,tab1);
    for(int i = 0;i < 4;i++){
        printf("%d\n", *(tab2 + i));
    }
    return 0;
}
