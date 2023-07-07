#include <stdio.h>
#include <stdlib.h>

int main()
{
    int x1 = 0;
    int x2 = 0;
    int y1 = 0;
    int y2 = 0;
    int r1 = 0;
    int r2 = 0;
    scanf("%d",&x1);
    scanf("%d",&y1);
    scanf("%d",&r1);
    scanf("%d",&x2);
    scanf("%d",&y2);
    scanf("%d",&r2);
    if((x1*y2-x2*y1) != 0){
    double a = (double)(r1*y2-y1*r2)/(x1*y2-x2*y1);
    double b = (double)(x1*r2-x2*r1)/(x1*y2-x2*y1);
    printf("%lf ",a);
    printf("%lf",b);
    }
    return 0;
}
