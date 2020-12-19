/**
 * @author: kozan
 * @date: 26-10-2020
 * */
package linkedstudy;

import java.security.InvalidParameterException;
import java.util.*;

import static java.util.Arrays.copyOf;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        char[] data = {'a','d','c','k','b'};

        char[] data2 = {'a','d','c','k','b'};
        char[] data7 = copyOf(data2, 3);
        insertionSort(data);
        insertionSort(data2);
        Arrays.fill(data2,'X');
        char[] data3 = copyOf(data, 2);

        char[] data4 = Arrays.copyOfRange(data, 1,3);
        for (char c : data4) System.out.println(c);
        System.out.println(java.util.Arrays.equals(data,data2));
        System.out.println(java.util.Arrays.toString(data));

        int[] dataRandom = new int[100];
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        for (int i = 0; i < dataRandom.length; i++)
            dataRandom[i] = random.nextInt();
        int[] copyData = copyOf(dataRandom, dataRandom.length);
        System.out.println("before sort array is equal: " + Arrays.equals(dataRandom, copyData));
        Arrays.sort(copyData);
        System.out.println("after sort array is equal: " + Arrays.equals(dataRandom, copyData));

        SinglyLinkedList<Integer> listInt = new SinglyLinkedList<>();
        listInt.addFirst(2);
        listInt.addFirst(3);
        listInt.addFirst(4);
        SinglyLinkedList<Integer> newest;
        newest = listInt.clone();
        System.out.println(newest.equals(listInt));

        int[] arr = {23,4,5,6,34};
        reversedArr(arr);
        System.out.println(arr[0]);

        double[][] aa = {{2,3,4}, {3,4,5,}, {5,6,7}};
        double[][] bb = {{2,3,7}, {8,4,5,}, {9,6,7}};
        double[][] resultMultiplication = matrixMultiplication(aa, bb);
        System.out.println("aa and bb with matrix multiplication: ");
        for (int i = 0; i < aa.length; i++){
            for (int j = 0; j < aa.length; j++){
                System.out.print(resultMultiplication[i][j] + " ");
            }
            System.out.println();
        }
        SinglyLinkedList<Integer> singly = new SinglyLinkedList<>();
        singly.addFirst(23);
        singly.addFirst(35);
        singly.addFirst(45);
        singly.addFirst(356);
        singly.addFirst(46);
        System.out.println(singly.last());
        singly.lastToSecond();

        DoublyLinkedList<Integer> db = new DoublyLinkedList<>();
        db.addFirst(1);
        db.addFirst(2);
        db.addFirst(3);
        db.addFirst(4);
        db.addFirst(5);
        System.out.println(db.middle());

        int[] A = {2,3,4,5,23,45,12,34,123,56,67,7};
        int[] result = findMaxMin(A, 0, A.length);
        System.out.println(result[0] + " " + result[1]);
    }

    //Greedy Algorithm Optimizations
    public static int[] findMaxMin(int[] data, int low, int high){
        //result[0] = min, result[1] = max...
        int[] result = new int[2];
        if(low==high){
            result[0] = data[0];
            result[1] = data[0];
            return result;
        }else if(low+1 == high){
            if (data[low] < data[high]){
                result[0] = data[low];
                result[1] = data[high];
            }else{
                result[0] = data[high];
                result[1] = data[low];
            }
            return result;
        }else{
            int mid = (high-low)/2;
            if(mid%2!=0)
                mid = mid + 1;
            int[] result1 = findMaxMin(data, low, low+mid-1);
            int[] result2 = findMaxMin(data, low+mid, high);
            result[0] = Math.min(result1[0], result2[0]);
            result[1] = Math.max(result1[1], result2[1]);
            return result;
        }
    }

    public static void insertionSort(char[] data){
        int n = data.length;
        for(int k = 1; k < n; k++){
            char current = data[k];
            int j = k;
            while (j > 0 && data[j-1] > current){
                data[j] = data[j-1];
                j--;
            }
            data[j] = current;
        }
    }

    public static void reversedArr(int[] arr){
        int N = arr.length;
        for (int i = 0; i < N / 2; i++){
            int temp = arr[i];
            arr[i] = arr[N - 1 - i];
            arr[N - 1 - i] = temp;
        }
    }

    public static double[][] matrixMultiplication(double[][] matrix1, double[][] matrix2)
            throws InvalidParameterException{
        if (matrix1.length != matrix2.length)
            throw new InvalidParameterException("Matrix's length must be equal...");
        double[][] result = new double[matrix1.length][matrix1.length];
        for (int i = 0; i < matrix1.length; i++){
            for (int j = 0; j < matrix1.length; j++){
                for (int k = 0; k < matrix1.length; k++){
                    result[i][j] += matrix1[i][k] * matrix1[k][j];
                }
            }
        }
        return result;
    }
}
