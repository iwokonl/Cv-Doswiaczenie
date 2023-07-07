#include <stdio.h>
#include <stdlib.h>

int rek2(int n){
    if(n == 0 || n == 1 || n == 2){
        return 1;
    }
    if(n % 3 == 0){
        return rek2(n-1) + rek2(n-2);
    }
    else if(n % 3 == 1){
        return 5*rek2(n-1) + 4;
    }
    else{
        return rek2(n-1);
    }
}

int main()
{
    printf("%d\n" , rek2(3));
    return 0;
}
