#include <stdio.h>
#include <stdlib.h>

int NWD(int a, int b)
{
    while(a!=b)
       if(a>b)
           a-=b;
       else
           b-=a;
    return a;
}
int foo(int n){
    int temp = 0;
    for(int i = 2;i<n;i++){
        if(NWD(i,n) == 1){
        temp += i;
        }
    }
    return temp;
}
int main()
{
    printf("%d\n", foo(14));
    return 0;
}
