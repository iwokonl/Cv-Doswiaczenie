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
public class SelectionSort{

    public void selectionSort(int[] array){
        for(int i = 0;i<array.length;i++){
            int min_idex = i;
            for (int z = i;z<array.length;z++){
                if(array[min_idex] > array[z]){
                    min_idex = z;
                }
            }
            swap(array, min_idex, i);
        }

    }


}
