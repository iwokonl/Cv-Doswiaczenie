#include <stdio.h>
#include <stdlib.h>
void sklej(char napis1[], char napis2[], char napis3[]){
    int i = 0;
    int temp = 0;
    while(napis1[i] != '\0'){
        napis3[temp] = napis1[i];
        temp++;
        i++;
    }

    i = 0;
    while(napis2[i] != '\0'){
        napis3[temp] = napis2[i];
        temp++;
        i++;
    }
    napis3[temp+1] = NULL;

}
int main()
{
    char napis1[]="iwo";
    char napis2[]=" stanislawski";
    char napis3[17];
    sklej(napis1,napis2,napis3);
    printf("%s", napis3);
    return 0;
}
