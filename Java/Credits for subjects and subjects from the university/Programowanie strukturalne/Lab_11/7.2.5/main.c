#include <stdio.h>
#include <stdlib.h>
struct punkt10{
    int wspolrzedne[10];

};

void foo(struct punkt10 o1[],struct punkt10 o2[],int n){
    for(int i=0;i<n;i++){
        for(int y=0;y<10;y++){
            o1[i].wspolrzedne[y] = o2[i].wspolrzedne[y];
        }
    }

}
void wyswietl(struct punkt10 o1[], int n){
for(int i=0;i<n;i++){
        for(int y=0;y<10;y++){
            printf("%d ", o1[i].wspolrzedne[y]);
        }
        printf("\n");
    }
}
int main()
{
    struct punkt10 o1[] = {{{1,2,3,4,5}},{{6,7,8,9,10}}};
    struct punkt10 o2[] = {{{6,7,8,9,10}},{1,2,3,4,5}};
    wyswietl(o1,2);
    wyswietl(o2,2);
    printf("\n");
    foo(o1,o2,2);
    wyswietl(o1,2);
    wyswietl(o2,2);
    return 0;
}
