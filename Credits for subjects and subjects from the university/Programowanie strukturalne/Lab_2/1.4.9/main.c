#include <stdio.h>
#include <stdlib.h>

int main()
{
    int a = 0;
    int b = 0;
    scanf("%d", &a);
    scanf("%d", &b);
    while(a!=b)
       if(a>b)
           a-=b;
       else
           b-=a;
    printf("%d",a);
    return 0;
}
