#include <stdio.h>
#include <stdlib.h>

struct punkt{
    float a;
    float b;
    float c;
};

void foo(struct punkt o1[], int n){
    float temp = 0;
    float max = 0;
    for(int i = 0;i<n;i++){
        for(int y = 0;y<n;y++){
                temp = o1[i].a +o1[y].a;
            if(temp > max){
                max = temp;
            }
        }
    }
    printf("%lf", temp);
}
void wyswietl(struct o1[], int n){
for(int i = 0;i<n;i++){
       printf("%lf %lf %lf ", o1[i].a, o1[i].b, o1[i].c);
    }
}
int main()
{
    struct punkt o[] = {{1,1,1},{2,2,2}};
    struct punkt o[] = {{3,3,3},{3,3,3}};
    foo(o, 2);
    return 0;
}
