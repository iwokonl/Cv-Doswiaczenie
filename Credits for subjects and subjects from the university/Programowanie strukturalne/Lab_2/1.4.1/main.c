#include <stdio.h>
#include <stdlib.h>

int main()
{
    int m = 0;
    int n = 0;
    scanf("%d", &n);
    scanf("%d", &m);
    int temp = n;
    while(temp<m){
        printf("%d\n" ,temp);
        temp += n;

    }
    return 0;
}
