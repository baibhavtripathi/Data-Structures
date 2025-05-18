package ai.tribty.array;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InitialArrayExamples {
    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 5, 3};

        // Traversal
        System.out.println(
            IntStream.of(arr)
                .mapToObj(String::valueOf)
                .reduce((a, b) -> a + " " + b)
                .orElse("")
        );
        // Linear search
        System.out.printf("LS: Key %d found? %b\n", 1, (linearSearch(arr, 1) != -1? true: false));
        // Binary search
        System.out.printf("BS: Key %d found? %b", 6, (binarySearch(arr, 0, arr.length, 6) != -1? true: false));

        
    }

    private static int linearSearch(int[] ar, int key) {
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] == key) {
                return i;
            }
        }
        return -1;
    }

    private static int binarySearch(int[] ar, int l, int r, int key) {
        if (l > r) {
            return -1;
        }
        Arrays.sort(ar);
        int mid = l + (r-1)/2;
        if (ar[mid] == key) {
            return mid;
        }
        if (ar[mid] > key) {
            return binarySearch(ar, l, mid-1, key);
        } else {
            return binarySearch(ar, mid+1, r, key);
        }
    }
}
