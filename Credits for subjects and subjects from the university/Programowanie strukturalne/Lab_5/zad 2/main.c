#include <stdio.h>
#include <stdlib.h>
int foo(int (*wsk)(int),int (*wsk2)(int), int n){
    return wsk(n) + wsk2(n);
}
int pom(int x){
    return x;
}
int main()
{
    printf("%d", foo(pom,pom,4));
    return 0;
}
