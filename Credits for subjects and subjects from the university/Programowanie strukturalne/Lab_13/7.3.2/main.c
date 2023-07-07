#include <stdio.h>
#include <stdlib.h>

struct element
{
    int i;
    struct element * next;
};

struct element * wyczysc(struct element * lista)
{
    struct element * wsk= lista;
    struct element * wsk2 = wsk;
    while(wsk!= NULL)
    {
        wsk= wsk->next;
        free(wsk2);
        wsk2= wsk;
    }
    return NULL;
}

void wyswietl(struct element * lista)
{
    if (lista == NULL)
    {
        printf("Lista jest pusta\n");
        return;
    }
    struct element * wsk= lista;
    while(wsk !=NULL)
    {
        printf("%d\n", wsk->i);
        wsk= wsk->next;
    }
    printf("----\n");
}
//lista bez glowy
int main()
{
    struct element * lista = malloc(sizeof(struct element));
    lista->i = 2;
    lista->next = malloc(sizeof(struct element));
    lista->next->i = -5;
    lista->next->next= malloc(sizeof(struct element));
    lista->next->next->i = 8;
    lista->next->next->next= NULL;
    wyswietl(lista);
    lista=wyczysc(lista);
    wyswietl(lista);
    return 0;
}
