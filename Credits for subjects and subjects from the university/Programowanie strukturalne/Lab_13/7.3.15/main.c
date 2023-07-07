#include <stdio.h>
#include <stdlib.h>
struct element
{
    int i;
    struct element * next;
};

struct element *znajdz(struct element *o, int a){
    if (o == NULL)
    {
        return NULL;
    }
    struct element * wsk= o->next;
    while(wsk !=NULL)
    {
        if(wsk->i == a){
            return wsk;
        }
        wsk= wsk->next;
    }
};//lista z glowa

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
    if(znajdz(lista,2) == NULL){
        printf("NULL");
    }
    else{
        printf("%d", znajdz(lista,2)->i);
    }
    return 0;
}
