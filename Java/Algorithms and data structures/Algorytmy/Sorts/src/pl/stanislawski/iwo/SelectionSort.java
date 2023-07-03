package pl.stanislawski.iwo;


import static pl.stanislawski.iwo.Swap.swap;

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
