package pl.stanislawski.iwo;

public class Swap {
    protected static void swap(int[] array, int index1,int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
