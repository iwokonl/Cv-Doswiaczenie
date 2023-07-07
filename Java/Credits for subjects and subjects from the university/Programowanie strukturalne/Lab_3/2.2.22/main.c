#include <stdio.h>
#include <stdlib.h>
int rek(int n){
    if(n == 0){
        return 1;
    }
    if(n == 1){
        return 1;
    }
    return rek(n-1) + 2*rek(n-2) + 3;
}
int main()
{
    printf("%d\n", rek(3));
    return 0;
}
