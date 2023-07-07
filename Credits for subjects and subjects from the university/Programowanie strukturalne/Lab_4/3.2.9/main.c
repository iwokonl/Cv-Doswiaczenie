#include <stdio.h>
#include <stdlib.h>
int* zarezerwuj(){
    int* i = (int *) malloc(sizeof(int));
    printf("%p\n", i);
    return i;

}
int main()
{
    int* x = zarezerwuj();
    printf("%p", x);
    return 0;
}
