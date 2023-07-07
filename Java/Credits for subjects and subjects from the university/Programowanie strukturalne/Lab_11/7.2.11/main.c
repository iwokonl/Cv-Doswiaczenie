#include <stdio.h>
#include <stdlib.h>
union liczba{
    int calk;
    double wym;

};

 struct Dane{
    int tp;
    union liczba zaw;
    };

void ustal(struct Dane *o1){
    scanf("%d",&o1->tp);
    if(o1->tp == 0){
        scanf("%d",&o1->zaw.calk);
    }

    if(o1->tp == 1){
        scanf("%lf",&o1->zaw.wym);
    }
}

void wypisz(struct Dane *o1){
    if(o1->tp == 0){
        printf("%d", o1->zaw.calk);
    }
    if(o1->tp == 1){
        printf("%lf", o1->zaw.wym);
    }

}

int main
()
{
    struct Dane o1;
    ustal(&o1);
    wypisz(&o1);
    return 0;
}
