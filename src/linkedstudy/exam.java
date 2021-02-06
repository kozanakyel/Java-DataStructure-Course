package linkedstudy;

import java.util.Random;
/**
 *
 * @author: Uğur Akyel
 *
 **/

public class exam {
    public static void main(String[] args){
        int[] arr = {23,4,5,67,78,89};
        removedArray(arr);

    }

    public static void insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++){
            int current = arr[i];
            int j = i;
            while (j > 0 && arr[j-1] > current){  // current den gerri dogru sardırıyoruz.
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = current;
        }
    }

    public static void removedArray(int[] arr){
        Random random = new Random();

        while (arr.length > 0){
            int selected = random.nextInt(arr.length);
            int[] arrCurrent = new int[arr.length-1];
            for (int i = 0; i < selected; i++)
                arrCurrent[i] = arr[i];
            for (int i = selected; i < arr.length-1; i++)
                arrCurrent[i] = arr[i+1];
            arr = arrCurrent;
        }

    }
}
