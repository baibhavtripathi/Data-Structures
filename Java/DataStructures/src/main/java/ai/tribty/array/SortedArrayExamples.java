package ai.tribty.array;

import java.util.Arrays;

public class SortedArrayExamples {
    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 5, 3, 0, 0, 0};
        // sort
        Arrays.sort(arr);
        System.out.println("Target Found? " + ((binarySearch(arr, 0, arr.length-1, 15) != -1)? "yes": "no"));
        System.out.println("Key insert successful? " + ((insertAtEnd(arr, 4, 15) != -1)? "yes": "no"));
        System.out.println(Arrays.toString(arr));
    }

    private static int binarySearch(int[] arr, int low, int high, int key) {
        if (low > high)
            return -1;
        int mid = (low + high) / 2;
        if (arr[mid] == key) {
           return mid; 
        } else if (arr[mid] > key) {
            return binarySearch(arr, low, mid-1, key);
        } else {
            return binarySearch(arr, mid+1, high, key);
        }
    }

    private static int insertAtEnd(int[] arr, int endIndex, int element) {
        if (endIndex >= arr.length) {
            System.out.println("ArrayIndexOutOfBoundsException");
            return -1;
        }
        arr[endIndex + 1] = element;
        return endIndex + 1;
    }
}
