#include <stdio.h>
#include <stdlib.h>
enum zwierzak{
    pies = 1,
    kot = 2,
    ptak = 3,
    riba = 4

};
int main()
{
    enum zwierzak Zwierzak;
    Zwierzak = pies;
    printf("%d" ,Zwierzak);
    return 0;
}
