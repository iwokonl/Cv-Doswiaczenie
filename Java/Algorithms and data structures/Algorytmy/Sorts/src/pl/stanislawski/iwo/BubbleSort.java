package pl.stanislawski.iwo;

public class BubbleSort {
    public  void bubbleSort(int[] arr){
        int current;
        int index;
        for(int i = 0;i<arr.length;i++){
            current = arr[0];
            index = 0;
            for(int z = 0;z<arr.length-1-i;z++){
                if(current > arr[z+1]){
                    swap(arr,index,z+1);
                    index++;
                }
            }
        }
    }
    private static void swap(int arr[], int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
