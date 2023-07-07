#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
bool foo(int (*wsk)(int),int (*wsk2)(int),unsigned int n){
    for(int i = 0;i<=n;i++){

        if(wsk(i) != wsk2(i)){
            return false;
        }
        if(i==n){
            return true;
        }
    }
}
int pom(int a){
    return a;
}
int main()
{
    printf("%d", foo(pom,pom,2));
    return 0;
}
