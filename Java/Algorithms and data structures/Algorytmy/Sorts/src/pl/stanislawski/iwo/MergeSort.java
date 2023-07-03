package pl.stanislawski.iwo;
/*
Algorytm polega na rozbijaniu na coraz mniejsze tablice a następnie każdą z tych mniejszych tablic sortujemy.

1. Napisz warunek stopu że tablica nie może być mniejsza niż 1
2. Podziel tablice na dwie części
3. Wrzuć lewą i prawą część do mergeSort
4. Posortuj tablicę lewą i prawą w zsumowanej talibcy
 */
public class MergeSort{

    public static void mergeSort(int[] array){
        int lenght = array.length;
        if(lenght <= 1){
            return;
        }
        // Przygotowanie mniejszych tablic
        int middle = lenght/2;
        int[] left = new int[middle];
        int[] right = new int[lenght - middle];
        // Przypisanie wartości do mniejszych tablic
        for (int i = 0; i < lenght; i++) {
            if(i < middle){
                left[i] = array[i];
            }
            else {
                right[i-middle] = array[i];
            }
        }
        // Podzielenie na mniejsze tablice aż rozmiar nie osiągnie 1.
        mergeSort(left);
        mergeSort(right);
        // Sortowanie i scalanie
        merge(left,right,array);

    }
    private static void merge(int[] left, int[] right,int[] array){
        int leftsize = array.length/2;
        int rightsize = array.length - leftsize;
        int i =0;
        int l =0;
        int r =0;

        while(l < leftsize && r < rightsize){
            if(left[l]<right[r]){
                array[i] = left[l];
                l++;
                i++;
            }else {
                array[i] = right[r];
                i++;
                r++;
            }
        }
        while (l<leftsize){
            array[i] = left[l];
            i++;
            l++;
        }
        while (r<rightsize){
            array[i] = left[r];
            i++;
            r++;
        }
    }


}
