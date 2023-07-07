#include <stdio.h>
#include <stdlib.h>
double foo(int n){
    double temp = 7;
    for(int i = 0;i<n-1;i++){
        temp *= 7;
    }
    return 1/temp;

}
int main()
{
    printf("%lf", foo(1));
    return 0;
}
