#include <stdio.h>
#include <stdlib.h>

int main()
{
    int n = 0;
    int m = 0;
    int temp = 1;
    scanf("%d", &n);
    scanf("%d", &m);

    for(int i = n;i<=m;i++){
        temp *= i;
    }
    printf("%d" , temp);

    return 0;
}
