#include <stdio.h>
#include <stdlib.h>

int main()
{
    int i = 0;
    int ii = 0;
    scanf("%d", &i);
    scanf("%d", &ii);
    if(abs(i) < abs(ii)){
        printf("%d", i);
    }
    if(abs(ii) < abs(i))
    {
        printf("%d", i);
    }
    else{
        printf("%s", "sa rowne");
    }
    return 0;

}
