#include <stdio.h>
#include <stdlib.h>

struct punkt{
    float a;
    float b;
    float c;
};

void foo(struct punkt o1[],struct punkt o2[], int n){
    for(int i = 0;i<n;i++){
       o2[i] = o1[i];
    }
}
void wyswietl(struct punkt o1[], int n){
for(int i = 0;i<n;i++){
       printf("%lf %lf %lf \n", o1[i].a, o1[i].b, o1[i].c);
    }
}
int main()
{
    struct punkt o1[] = {{1,1,1},{2,2,2}};
    struct punkt o2[] = {{3,3,3},{3,3,3}};
    foo(o1,o2, 2);
    wyswietl(o1,2);
    wyswietl(o2,2);
    return 0;
}
