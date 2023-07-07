#include <stdio.h>
#include <stdlib.h>
union super_int{
    int a;
    unsigned int b;

};
int main()
{
    union super_int o1;
    o1.a = 1;
    o1.b = 2;
    printf("%d %d",o1.a,o1.b);
    return 0;
}
