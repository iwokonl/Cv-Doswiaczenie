#include <stdio.h>
#include <stdlib.h>

int main()
{
        int m = 0;
    int n = 0;
    int k = 0;

    scanf("%d", &n);
    scanf("%d", &m);
    scanf("%d", &k);
    int temp = n;
    if(n < 0 || m<0 || k < 0){
        printf("%s", "dodatnie maja byc");
        return 0;
    }
        while(temp<m){
        if(temp > k){
        printf("%d\n" ,temp);
        }
        temp += n;
    }


    int a = 0;
    int temp = 0;
    scanf("%d",&a);
    for(int n = 1;n<=a;n++){
        temp += n*n;
    }
    printf("%d" , temp);
    return 0;
}
