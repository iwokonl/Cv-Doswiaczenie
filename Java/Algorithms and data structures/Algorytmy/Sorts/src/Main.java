import pl.stanislawski.iwo.InsertionSort;
import pl.stanislawski.iwo.SelectionSort;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        int[] array = new int[]{4, 3, 2, 1};
        InsertionSort insertionSort = new InsertionSort();
        InsertionSort.insertionSort(array);
        for(int i = 0; i < array.length; ++i) {
            System.out.println(array[i]);
        }

    }
}
