#include <stdio.h>
#include <stdlib.h>
void przepisanie(int n,int *w){
    *w = n;

}
int main()
{
    int x = 0;
    int y = 22;
    przepisanie(x,&y);
    printf("%d", y);
    return 0;
}
