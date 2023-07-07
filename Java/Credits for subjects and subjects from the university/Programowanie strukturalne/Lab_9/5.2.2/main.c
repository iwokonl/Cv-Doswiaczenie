#include <stdio.h>
#include <stdlib.h>
int dlugosc(char napis[]){
    int i = 0;
    while(napis[i] != NULL){
        i++;
    }
    return i;

}
int main()
{
    char napis[] = "Iwo";
    printf("%d", dlugosc(napis));
    return 0;
}
