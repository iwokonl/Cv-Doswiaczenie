#include <stdio.h>
#include <stdlib.h>
struct element
{
    int i;
    struct element * next;
};

struct element * wyczysc(struct element * lista)
{
    struct element * wsk= lista->next;
    struct element * wsk2 = wsk;
    while(wsk!= NULL)
    {
        wsk= wsk->next;
        free(wsk2);
        wsk2= wsk;
    }
    return NULL;
}
//lista z glowa
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
    struct element * wsk = wyczysc(lista);
    while(wsk != NULL)
    {
        printf("%d\n", wsk->i);
        wsk = wsk->next;
    }
    return 0;
}
