import java.util.Arrays;
import java.util.Date;
import java.util.Timer;

public class Main {
    public static void main(String[] args) {
        double[] arr = randarr(10, true);

        System.out.println("The array is: " + calculateSortPercentage(arr) + "% correctly solved");

        /*
        float result1 = 0;
        float result2 = 0;
        float result3 = 0;
        float result4 = 0;
        float result5 = 0;

        for (int i = 0; i < 10; i++) {
            double[] arr = randarr(20, true);
            double[] arrb = randarr(13, true);
            result1 += testAlgorithm(arr, 1);
            result2 += testAlgorithm(arr, 0);
            result5 += testAlgorithm(arrb, 4);
            result3 += testAlgorithm(Sort.bubbleSort(arr), 2);
            result4 += testAlgorithm(Sort.bubbleSort(arr), 3);
        }

        System.out.println("Mergesort 1000 x 10 avg time: " + (result1 / 1000) + " microseconds");
        System.out.println("Bubblesort 1000 x 10 avg time: " + (result2 / 1000) + " microseconds");
        System.out.println("Linearsearch 1000 x 10 avg time: " + (result3 / 1000) + " microseconds");
        System.out.println("Binarysearch 1000 x 10 avg time: " + (result4 / 1000) + " microseconds");
        System.out.println("Bogosort 10 x 20 avg time: " + (result5 / 1000) + " microseconds");
        */
    }

    public static double[] randarr(int num, boolean doRound) {
        double[] arr = new double[num];
        for (int i = 0; i < num; i++) {
            if (doRound) arr[i] = (int) (Math.random() * num) + 1;
            else arr[i] = Math.random() * num + 1;
        }
        return arr;
    }

    public static void printArr(double[] arr) {
        for (double i : arr) {
            System.out.print(i + "; ");
        }
        System.out.println("\n");
    }

    public static float testAlgorithm(double[] arr, int algo) {
        //printArr(arr);
        switch (algo) {
            case 0: {
                long startTime = System.nanoTime();
                Sort.bubbleSort(arr);
                float time = (System.nanoTime() - startTime) / 1000f;
                //System.out.println("MergeSort " + arr.length + " : " + time + " microseconds");
                return time;
            }
            case 1: {
                long startTime = System.nanoTime();
                Sort.mergeSort(arr);
                float time = (System.nanoTime() - startTime) / 1000f;
                //System.out.println("MergeSort " + arr.length + " : " + time + " microseconds");
                return time;
            }
            case 2: {
                long startTime = System.nanoTime();
                Search.linearSearch(arr, arr[(int) (Math.random()* arr.length)]);
                float time = (System.nanoTime() - startTime) / 1000f;
                //System.out.println("MergeSort " + arr.length + " : " + time + " microseconds");
                return time;
            }
            case 3: {
                long startTime = System.nanoTime();
                Search.binarySearch(arr, arr[(int) (Math.random()* arr.length)]);
                float time = (System.nanoTime() - startTime) / 1000f;
                //System.out.println("MergeSort " + arr.length + " : " + time + " microseconds");
                return time;
            }
            case 4: {
                long startTime = System.nanoTime();
                Sort.bogoSort(arr);
                float time = (System.nanoTime() - startTime) / 1000f;
                //System.out.println("MergeSort " + arr.length + " : " + time + " microseconds");
                return time;
            }
            default: {
                System.out.println("Error: Unknown algorithm");
                return 0f;
            }
        }
    }

    public static double calculateSortPercentage(double[] arr) {
        if(arr.length <= 1) {
            return 100;
        }

        int sortedCount = 0;

        for(int i = 0; i < arr.length -1; i++) {
            if(arr[i] <= arr[i+1]) {
             sortedCount++;
            }
        }

        return (double) sortedCount / (arr.length) * 100;
    }
}
