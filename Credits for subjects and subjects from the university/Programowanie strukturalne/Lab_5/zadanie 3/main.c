#include <stdio.h>
#include <stdlib.h>
int rek(int n){
    if(n==0 || n == 1){
        return 1;
    }
    if(n%3 == 0){
        return rek(n/3);
    }
    if(n%3 == 1){
        return rek((n-1)/3)+1;
    }
    if(n%3 == 2){
        return rek(n-1)-1;
    }

}
int main()
{
    printf("%d\n" , rek(4));
    return 0;
}
