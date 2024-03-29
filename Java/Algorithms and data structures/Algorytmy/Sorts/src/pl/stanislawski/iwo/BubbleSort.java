package pl.stanislawski.iwo;

import static pl.stanislawski.iwo.Swap.swap;

/*
Algorytm przechodzi po każdym elemencie i porównuje go z następnym jeżeli następny jest większy to zamienia element
aktualny(current) z elementem następnym.

Złożoność obliczeniowa O(n^2).

1. Weź pierwszy element z listy.
2. Porównaj go z następnym elementem.
3. Jeżeli element następny jest większy zamień go.

 */
public class BubbleSort {
    public  void bubbleSort(int[] arr){
        int current;
        int index;
        // Przechodzenie po elementach.
        for(int i = 0;i<arr.length;i++){
            // Wybieranie pierwszego elementu.
            current = arr[0];
            index = 0;
            for(int z = 0;z<arr.length-1-i;z++){
                // Porównywanie elementu aktualnego z następnym elementem. Zamiana elementu i zapamiętywanie gdzie
                // jest aktualny element.
                if(current > arr[z+1]){
                    swap(arr,index,z+1);
                    index++;
                }
            }
        }
    }

}
