#include <stdio.h>
#include <stdlib.h>
struct zespolone{
    double im;
    double re;

};
struct zespolone foo(struct zespolone *o1, struct zespolone *o2){
    struct zespolone temp = {o1->im+o2->im, o1->re + o2->re};
    return temp;
}
void wyswietl(struct zespolone *o1){
    printf("%lf  %lf", o1->im, o1->re);
}
int main()
{
    struct zespolone o1 = {1,1};
    struct zespolone o2 = {1,1};
    struct zespolone temp = foo(&o1,&o2);
    wyswietl(&temp);
    return 0;
}
