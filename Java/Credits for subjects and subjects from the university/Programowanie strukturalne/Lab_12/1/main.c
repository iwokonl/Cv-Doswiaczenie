#include <stdio.h>
#include <stdlib.h>
struct ksiazka{
    char tytul[50];
    int liczba_stron;
};

struct ksiazka *initksiazka(int liczba_stron, char *tytul){
    int z = 0;
    while(*(tytul+z) != '\0'){
        z++;
    }
    if(z >= 5 && z <= 50){
        return NULL;
    }
    struct ksiazka *temp = (struct ksiazka*) malloc(sizeof(struct ksiazka));
    temp->liczba_stron=50;
    for(int i = 0;i<z;i++){

        *(temp->tytul + i) = *(tytul + i);
    }
    *(temp->tytul+z) = '\0';
    return temp;
}
void pokazKsiazka(struct ksiazka *temp){
    printf("%s, %d", temp->tytul,temp->liczba_stron);
}

void dodajstrony(struct ksiazka *temp){
    temp->liczba_stron += 10;
}
int main()
{
    struct ksiazka *temp = initksiazka(50,"iwo");
    dodajstrony(temp);
    pokazKsiazka(temp);

    return 0;
}
