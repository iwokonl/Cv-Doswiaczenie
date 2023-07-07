#include <stdio.h>
#include <stdlib.h>
double foo(int n, int m,int **tab){
    double temp;
    int sum = 0;
    for(int x = 0;x<n;x++){
        *(tab+x);
            for(int z = 0;z<m;z++){
                sum += *(*(tab+z)+x);
            }
        if(x == 0){
            temp = sum/m;
        }
        if(temp < sum/m){
            temp = sum/m;
        }
    sum = 0;
    }
    return temp;
}
int main()
{
    int n = 5;
    int m = 5;
    int **tab= malloc(sizeof(int*)*n);
    for(int i = 0;i<m;i++){
        *(tab + i) = malloc(sizeof(int)*m);
    }
    for(int x = 0;x<n;x++){
            *(tab+x);
        for(int z = 0;z<m;z++){
                *(*(tab+z)+x) = x*z;
        }
    }
    printf("%lf", foo(n,m,tab));
    return 0;
}
