#include <stdio.h>
#include <stdlib.h>
void kopjujn(char napis1[],char napis2[],int n){
    int i = 0;
    int temp = 0;
    while(napis2[i] != '\0'){
        if(napis2[i] != '\0'){
            temp++;
        }
        i++;
    }
    for(int z = 0;z<n;z++){
        napis2[n+z+1] = napis1[z];
    }
}
int main()
{
    char napis1[] = "st";
    char napis2[6] = "Iwo";
    kopjujn(napis1,napis2,2);
    printf("%s", napis2);
    return 0;
}
