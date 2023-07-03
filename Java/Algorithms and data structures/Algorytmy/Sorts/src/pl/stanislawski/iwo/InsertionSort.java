package pl.stanislawski.iwo;
import static pl.stanislawski.iwo.Swap.swap;
/*
Wizualizacja: https://www.hackerearth.com/practice/algorithms/sorting/selection-sort/visualize/

Algorytm polega na tym, że bierzesz index pierwszej wartości porównujesz aż nie znajdziesz więszkej. Jak znajdziesz zamieniasz index na więszką.
Potem zamieniasz tą z najwięszką wartością z ostatnim elementem nie posortowanym(czyli odejmujesz jeden z długości tablicy).

Złożoność obliczeniowa: O(n^2).

1. Weź index pierwszej wartości.
2. Sprawdź czy jest jakaś więsza wartość
3. Zamień wartość jeśli jest jest większa
4. Zamień wartość z ostatnią wartością nie posortowaną.

 */
public class InsertionSort{
    public static void insertionSort(int[] array){
        int key = 0;
        int index;
        for (int i = 0; i < array.length-i; i++) {
            index= i;
            for (int k = 0; k < array.length-i; k++) {
                if(array[index] < array[k]){
                    index = k;
                }
                key = k;
            }
            swap(array, index,key);
        }
    }
}
