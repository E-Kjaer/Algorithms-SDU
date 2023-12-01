public class Search {
    public static int linearSearch(double[] arr, double target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(double[] arr, int left_index, int right_index, double target) {
        if (right_index >= left_index) {
            int middle = (left_index + right_index) / 2;
            if (arr[middle] == target) {
                return middle;
            } else if (arr[middle] > target) {
                return binarySearch(arr, left_index, middle - 1, target);
            } else if (arr[middle] < target) {
                return binarySearch(arr, middle + 1, right_index, target);
            }
        }
        return -1;
    }

    public static int binarySearch(double[] arr, double target) {
        return binarySearch(arr, 0, arr.length - 1, target);
    }
}
