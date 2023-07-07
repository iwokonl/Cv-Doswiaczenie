#include <stdio.h>
#include <stdlib.h>
int foo(int **tab, int n){
    int temp=0;
    for(int i = 0;i<n;i++){
        for(int z = 0;z<100;z++){
            temp += tab[i][z];
        }
    }
    return temp;

}
int main()
{
    int **tab= malloc(sizeof(int*)*2);
    for(int i = 0;i<3;i++){
        *(tab+i) = malloc(sizeof(int)*100);
        for(int z = 0;z<100;z++){
            tab[i][z]=1;
        }
    }
    printf("%d\n",foo(tab,3));
    return 0;
}
