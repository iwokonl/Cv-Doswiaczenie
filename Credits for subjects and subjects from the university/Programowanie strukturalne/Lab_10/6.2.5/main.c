#include <stdio.h>
#include <stdlib.h>
int ***alokuj(int n, int m,int z){
    int ***tab = malloc(n*sizeof(int**));
    for(int i = 0;i<m;i++){
        **(tab+i) = malloc(m*sizeof(int*));
        for(int y = 0;y<z;y++){
            *(tab+y) = malloc(z*sizeof(int));
        }
    }
    return tab;
}

void zwolnij(int ***tab,int n ,int m,int z){

    for(int i =0;i<z;i++){
        free(***(tab+i));
    }
    for(int i =0;i<m;i++){
        free(**(tab+i));
    }
    free(*tab);
}
int main()
{
    printf("Hello world!\n");
    return 0;
}
