#include <stdio.h>
#include <stdlib.h>
int rek3(int n,int m){
    if(m == 0){
        return n;
    }
    if(n == 0){
        return m;
    }
    return n - m + rek3(n-1,m) + rek3(n,m - 1);
}
int main()
{
    printf("%d\n", rek3(4,3));
    return 0;
}
