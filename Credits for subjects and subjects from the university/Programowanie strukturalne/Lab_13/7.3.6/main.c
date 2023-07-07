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
    struct element * wsk= o;
    while(wsk !=NULL)
    {
        if(wsk->i == a){
            return wsk;
        }
        wsk= wsk->next;
    }
};//lista bez glowy
int main()
{
    struct element * lista = malloc(sizeof(struct element));
    lista->i = 2;
    lista->next = malloc(sizeof(struct element));
    lista->next->i = -5;
    lista->next->next= malloc(sizeof(struct element));
    lista->next->next->i = 8;
    lista->next->next->next= NULL;
    if(znajdz(lista,2) == NULL){
        printf("NULL");
    }
    else{
        printf("%d", znajdz(lista,2)->i);
    }
    return 0;
}
