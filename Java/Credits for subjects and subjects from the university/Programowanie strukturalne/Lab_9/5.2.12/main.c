#include <stdio.h>
#include <stdlib.h>
void wytnijzn(char napis1[],char napis2[]){
    int i = 0;
    int temp = 0;
    while(napis2[temp] != '\0'){
        temp++;
    }
    while(napis1[i] != '\0'){
        for(int z = 0;z<temp;z++){
            if(napis1[i] == napis2[z]){
                napis1[i] = ' ';
            }
        }
        i++;
    }

}
int main()
{
    char napis1[]="abciasddaswadsasdo";
    char napis2[]="iwo";
    wytnijzn(napis1,napis2);
    printf("%s",napis1);
    return 0;
}
