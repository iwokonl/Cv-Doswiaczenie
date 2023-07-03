import pl.stanislawski.iwo.BubbleSort;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        int[] array = new int[]{4, 3, 2, 1};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(array);

        for(int i = 0; i < array.length; ++i) {
            System.out.println(array[i]);
        }

    }
}
