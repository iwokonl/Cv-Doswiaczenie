import pl.stanislawski.iwo.InsertionSort;
import pl.stanislawski.iwo.MergeSort;
import pl.stanislawski.iwo.SelectionSort;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        int[] array = new int[]{9,8,7,6,5,4,3,2,1,0};
        MergeSort insertionSort = new MergeSort();
        MergeSort.mergeSort(array);
        for(int i = 0; i < array.length; ++i) {
            System.out.println(array[i]);
        }

    }
}
