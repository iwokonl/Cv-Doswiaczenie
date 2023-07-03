package pl.stanislawski.iwo;
import static pl.stanislawski.iwo.Swap.swap;
/*
Algorytm polega na tym że zaczynamy od drugiego elementu. Porównujemy go z elementem poprzednim,
jeśli jest większy to zamieniamy(przepychamy ten element do tyłu) i tak do momentu aż nie skończy nam się tablica bądź element będzie mniejszy.
Potem idziemy do następnego

1. Weź element tablicy(przchowaj go bo zniknie i pętla musi zaczynać się od pierwszego elementu)
2. Weź index o jeden mniejszy niż w poprzednim kroku element na którym on stał
3. Sprawdź czy nie wyszedłeś poza tablice oraz czy element "na indeksie -1" jest większy(while).
Jeżeli jest większy przepchnij go do przodu o 1 i odejmij od indexu "-1".
4. Zapisz na indexie +1 element z pierwszego kroku
 */
public class InsertionSort{
    public static void insertionSort(int[] array){
        for (int i = 1; i < array.length; i++) {
            int element = array[i];
            int index = i - 1;
            while(index >= 0 && array[index] > element){
                array[index + 1] = array[index];
                index--;
            }
            array[index + 1] = element;

        }

    }
}
