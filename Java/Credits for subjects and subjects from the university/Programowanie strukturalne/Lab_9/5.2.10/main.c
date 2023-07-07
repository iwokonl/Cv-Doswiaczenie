#include <stdio.h>
#include <stdlib.h>
void wytnij(char napis1[], char napis2[]){
    int i = 0;
    int temp = 0;
    int flaga = 0;
    while(napis2[temp] != '\0'){
            temp++;
        }

    while(napis1[i] != '\0'){

        for(int z = 0;z<temp;z++){
            if(napis2[z] == napis1[z+i]){
                flaga++;

            }
        }
        if(flaga == temp){
            for(int z = 0;z<temp;z++){

            napis1[z+i] = ' ';

            }
            break;
        }
        flaga = 0;
        i++;
        }
    }


int main()
{
    char napis1[]="siwos";
    char napis2[]="iwo";
    wytnij(napis1,napis2);
    printf("%s",napis1);
    return 0;
}
