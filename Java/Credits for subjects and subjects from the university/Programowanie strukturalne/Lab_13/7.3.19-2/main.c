#include <stdio.h>
#include <stdlib.h>
struct element
{
    int i;
    struct element * next;
};

struct element* usun(struct element *o, int a){
    if (o->next == NULL)
    {
        return NULL;
    }
    if(o->next->i == a){
        struct element * wsk= o->next;
        free(o);
        return wsk;
    }
    struct element * wsk= o->next;
    while((wsk->next!=NULL) && (wsk->next->i != a)){
        wsk=wsk->next;
    }
    if(wsk->next!=NULL){
        struct element * wsk2= wsk->next;
        wsk->next = wsk->next->next;
        free(wsk2);
    }
    return o;
};//z glow�
int main()
{
    struct element * lista = malloc(sizeof(struct element));
    lista->next = malloc(sizeof(struct element));
    lista->next->i = 2;
    lista->next->next=malloc(sizeof(struct element));
    lista->next->next->i = -5;
    lista->next->next->next=malloc(sizeof(struct element));
    lista->next->next->next->i = 8;
    lista->next->next->next->next = NULL;

    struct element *wsk = lista = usun(lista,8)->next;
     while(wsk != NULL)
        {
        printf("%d\n", wsk->i);
        wsk = wsk->next;
    }
    return 0;
}
