#include <stdio.h>
#include <stdlib.h>
struct element
{
    int i;
    struct element * next;
};

struct element* usun(struct element *o, int a){
    if (o == NULL)
    {
        return NULL;
    }
    if(o->i == a){
        struct element * wsk= o->next;
        free(o);
        return wsk;
    }
    struct element * wsk= o;
    while((wsk->next!=NULL) && (wsk->next->i != a)){
        wsk=wsk->next;
    }
    if(wsk->next!=NULL){
        struct element * wsk2= wsk->next;
        wsk->next = wsk->next->next;
        free(wsk2);
    }
    return o;
};



//lista bezglowy
int main()
{
    struct element * lista = malloc(sizeof(struct element));
    lista->i = 2;
    lista->next = NULL;


    lista->next = malloc(sizeof(struct element));
    lista->next->i = -5;
    lista->next->next= malloc(sizeof(struct element));
    lista->next->next->i = 8;
    lista->next->next->next= NULL;
    lista = usun(lista,8);
     while(lista != NULL)
        {
        printf("%d\n", lista->i);
        lista = lista->next;
    }
    return 0;
}
