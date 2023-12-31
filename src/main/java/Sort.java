import java.util.ArrayList;
import java.util.Arrays;

public class Sort {
    public static double[] bubbleSort(double[] arr) {
        boolean exchanges = true;
        int p = arr.length - 1;
        while (p > 0 && exchanges) {
            exchanges = false;
            for (int i = 0; i < p; i++) {
                if (arr[i] > arr[i + 1]) {
                    exchanges = true;
                    double temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            p--;
        }
        return arr;
    }

    private static void merge(double[] arr, int left_index, int middle, int right_index) {
        double[] left_copy = Arrays.copyOfRange(arr, left_index, middle + 1);
        double[] right_copy = Arrays.copyOfRange(arr, middle + 1, right_index + 1);

        int left_copy_index = 0;
        int right_copy_index = 0;
        int sorted_index = left_index;

        while (left_copy_index < left_copy.length && right_copy_index < right_copy.length) {
            if (left_copy[left_copy_index] <= right_copy[right_copy_index]) {
                arr[sorted_index] = left_copy[left_copy_index];
                left_copy_index++;
            } else {
                arr[sorted_index] = right_copy[right_copy_index];
                right_copy_index++;
            }
            sorted_index++;
        }
        while (left_copy_index < left_copy.length) {
            arr[sorted_index] = left_copy[left_copy_index];
            left_copy_index++;
            sorted_index++;
        }
        while (right_copy_index < right_copy.length) {
            arr[sorted_index] = right_copy[right_copy_index];
            right_copy_index++;
            sorted_index++;
        }
    }

    private static double[] mergeSort(double[] arr, int left_index, int right_index) {
        if (left_index < right_index) {
            int middle = (left_index+right_index) / 2;
            mergeSort(arr, left_index, middle);
            mergeSort(arr, middle + 1, right_index);
            merge(arr, left_index, middle, right_index);
        }
        return arr;
    }

    public static double[] mergeSort(double[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    public static double[] bogoSort(double[] arr) {
        int i = 0;
        while (!isSorted(arr)) {
            shuffle(arr);
            i++;
        }
        System.out.println("tries: " + i);
        return arr;
    }

    private static void shuffle(double[] arr) {
        for (int x = 0; x < arr.length; ++x) {
            int index1 = (int) (Math.random() * arr.length);
            int index2 = (int) (Math.random() * arr.length);
            double a = arr[index1];
            arr[index1] = arr[index2];
            arr[index2] = a;
        }
    }

    private static boolean isSorted(double[] arr) {
        for (int x = 0; x < arr.length - 1; ++x) {
            if (arr[x] > arr[x + 1]) {
                return false;
            }
        }
        return true;
    }
}
