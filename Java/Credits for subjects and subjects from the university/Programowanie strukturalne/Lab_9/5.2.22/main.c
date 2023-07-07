#include <stdio.h>
#include <stdlib.h>
char *sklej(char napis1[], char napis2[], char napis3[]){
    int napis1_l = 0;
    int napis2_l = 0;
    int napis3_l = 0;
    int temp=0;
    while(napis1[napis1_l] != '\0'){
        napis1_l++;
    }
    while(napis2[napis2_l] != '\0'){
        napis2_l++;
    }
    while(napis3[napis3_l] != '\0'){
        napis3_l++;
    }
    char *napis_temp =  malloc(sizeof(char)*(napis1_l+napis3_l+napis2_l)+1);
    for(int i = 0;i<napis1_l;i++){
        *(napis_temp+temp) = napis1[i];
        temp++;
    }

     for(int i = 0;i<napis1_l;i++){
        *(napis_temp+temp) = napis2[i];
        temp++;
    }

     for(int i = 0;i<napis1_l;i++){
        *(napis_temp+temp) = napis3[i];
        temp++;
    }
    *(napis_temp+temp) = '\0';

    return napis_temp;
}
int main()
{
    char napis1[]="aasd";
    char napis2[]="b";
    char napis3[]="c";
    char *tablica = sklej(napis1,napis2,napis3);
    printf("%s", tablica);
    return 0;
}
