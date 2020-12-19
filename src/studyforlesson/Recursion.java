package studyforlesson;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;

public class Recursion {

    public static void main(String[] args){
        drawRuler(3,4);

        diskUsage(new File("src"));

        int[] arr = {2,3,4,5,6,7,8};
//        reverseArray(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);

        System.out.println(power(2.1,5));

        System.out.println(binarySum(arr, 0, arr.length-1));

        long[] fib = fibonacciGood(8);
        System.out.println(Arrays.toString(fib));

        System.out.println(binarySearch(arr, 5));
    }

    public static int binarySearch(int[] data, int target){
        return binarySearch(data, target, 0, data.length-1);
    }

    public static int binarySearch(int[] data, int target, int low, int high) {
        if (low > high)
            return -low-1;

        int mid = (low + high) / 2;
        if (target < data[mid])
            return binarySearch(data, target, low, mid - 1);
        else if (target == data[target])
            return mid;
        else
            return binarySearch(data, target, mid + 1, high);
    }

    public static long[] fibonacciGood(int n){
        if(n <= 1){
            return new long[]{n, 0};
        }else{
            long[] temp = fibonacciGood(n-1);
            long[] answer = {temp[0] + temp[1], temp[0]};
            return answer;
        }
    }

    public static int binarySum(int[] data, int low, int high){
        if (low > high)
            return 0;
        else if(low == high)
            return data[low];
        else{
            int mid = (low+high) / 2;
            return binarySum(data, low, mid) + binarySum(data, mid+1, high);
        }
    }

    public static double power(double base, int power){
        if (power == 0)
            return 1;
        double partial = power(base, power / 2);
        double result = partial * partial;
        if (power % 2 == 1)
            result = base * result;
        return result;
    }

    public static void drawRuler(int nInches, int majorLength){
        drawLine(majorLength, 0);
        for (int j = 1; j <= nInches; j++){
            drawInterval(majorLength - 1);
            drawLine(majorLength, j);
        }
    }

    private static void drawInterval(int centralLength){
        if (centralLength >= 1){
            drawInterval(centralLength - 1);
            drawLine(centralLength);
            drawInterval(centralLength - 1);
        }
    }

    private static void drawLine(int tickLength, int tickLabel){
        for (int j = 0; j < tickLength; j++)
            System.out.print("-");
        if (tickLabel >= 0)
            System.out.print(" " + tickLabel);
        System.out.print("\n");
    }

    private static void drawLine(int tickLength){
        drawLine(tickLength, -1);
    }

    public static long diskUsage(File root){
        long total = root.length();
        if (root.isDirectory()){
            for (String childname : Objects.requireNonNull(root.list())){
                File child = new File(root, childname);
                total += diskUsage(child);
            }
        }
        System.out.println(total + "\t" + root);
        return total;
    }

    public static int linearSum(int[] data, int n){
        if (n == 0)
            return 0;
        else
            return linearSum(data, n-1) + data[n-1];
    }

    public static void reverseArray(int[] data, int low, int high){
        if (low < high){
            int temp = data[low];
            data[low] = data[high];
            data[high] = temp;
            reverseArray(data, low+1, high-1);
        }
    }

}
