#include <stdio.h>
#include <stdlib.h>
int foo(int n, int tab[n][n][n]){
    int temp = 0;
        for(int x = 0;x<n;x++){
            for(int y = 0;y<n;y++){
                for(int z = 0;z<n;z++){
                    temp += tab[x][y][z];
                }
            }
        }
    return temp;
}
int main()
{

    int n = 70;
    int temp[n][n][n];
    for(int x = 0;x<n;x++){
        for(int y = 0;y<n;y++){
            for(int z = 0;z<n;z++){
                temp[x][y][z] = 1;

                }
        }
    }
    printf("%d", foo(n,temp));
    return 0;
}
