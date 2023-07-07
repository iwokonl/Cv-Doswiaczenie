#include <stdio.h>
#include <stdlib.h>
void foo(int n,int m,int tab[n][m]){

    for(int i = 0;i<n-1;i++){
        tab[i] = tab[i+1];
    }
}
int main()
{
    int tab[2][2];
    for(int i = 0;i<2;i++){
        for(int x = 0;x<2;x++){
            tab[i][x] = (i+1)*(x+1);
        }
    }
    for(int i = 0;i<2;i++){
        for(int x = 0;x<2;x++){
            printf("tab[%d][%d] = %d ",i,x,tab[i][x]);
        }
        printf("\n");
    }
    foo(2,2,tab);
        for(int i = 0;i<2;i++){
        for(int x = 0;x<2;x++){
            printf("tab[%d][%d] = %d ",i,x,tab[i][x]);
        }
        printf("\n");
    }
    return 0;
}
