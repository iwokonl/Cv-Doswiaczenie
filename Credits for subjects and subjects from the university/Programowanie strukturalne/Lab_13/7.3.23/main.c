#include <stdio.h>
#include <stdlib.h>
struct troj
{
    int a;
    int b;
    int c;
    struct troj * next;
};
struct troj* usun(struct troj *o){
    if (o == NULL)
    {
        return NULL;
    }
    if(o->c*o->c == o->a*o->a+o->b*o->b){
        struct troj * wsk= o->next;
        free(o);
        return wsk;
    }
    struct troj * wsk= o;
    while((wsk->next!=NULL) && (wsk->next->c*wsk->next->c == o->a*o->a+o->b*o->b)){
        wsk=wsk->next;
    }
    if(wsk->next!=NULL){
        struct troj * wsk2= wsk->next;
        wsk->next = wsk->next->next;
        free(wsk2);
    }
    return o;
};

int main()
{
    struct troj * lista = malloc(sizeof(struct troj));
    lista->a = 2;
    lista->b = 2;
    lista->c = 4;
    lista->next = malloc(sizeof(struct troj));
    lista->next->a = 5;
    lista->next->b = 5;
    lista->next->c = 444;
    lista->next->next= NULL;
    lista = usun(lista);
    while(lista != NULL)
    {
        printf("%d\n", lista->a);
        printf("%d\n", lista->b);
        printf("%d\n", lista->c);
        lista = lista ->next;
    }
    return 0;
}
