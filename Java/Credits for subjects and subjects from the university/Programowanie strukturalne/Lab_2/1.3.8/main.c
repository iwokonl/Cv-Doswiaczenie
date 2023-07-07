#include <stdio.h>
#include <stdlib.h>

int main()
{
    int bok1 = 0;
    int bok2 = 0;
    int bok3 = 0;
    printf("%s", "0: Kwadrat\n1:prostokat\n2:trojkat\n");
    scanf("%d", &i);
    if(i == 0){
        printf("%s", "podaj bok a\n");
        scanf("%d", &bok1);
        printf("%d",bok1*bok1);
    }
    if(i == 1){
        printf("%s", "podaj bok pdst i wysokosc\n");
        scanf("%d", &bok1);
        scanf("%d", &bok2);
        printf("%d",(bok1*bok2)/2);
    }
    return 0;
}
