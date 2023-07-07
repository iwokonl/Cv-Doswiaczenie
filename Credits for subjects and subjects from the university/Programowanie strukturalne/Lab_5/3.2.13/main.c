#include <stdio.h>
#include <stdlib.h>
double foo(double (*wsk)(int) ,int x){
    return wsk(x);
}

int foo2(int (*wsk)(int) ,int x){
    return wsk(x);
}

double pom(int a){
    return 5.0/a;
}
int pom2(int a){
    return 5;
}
int main()
{
    printf("%d", foo2(pom2,1));
    return 0;
}
