package ai.tribty.array;

import java.util.Arrays;
import java.util.stream.IntStream;

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
        // Sort the array before binary search
        Arrays.sort(arr);
        // Binary search
        System.out.printf("BS: Key %d found? %b\n", 6, (binarySearch(arr, 0, arr.length - 1, 6) != -1? true: false));
        
        printArray(arr);
        // Insertion
        int arrLengthBeforeInsertion = arr.length;
        Object[] insertedAtEndResult = insertAtEnd(arr, 4, 32);
        if ((int) insertedAtEndResult[0] >= arrLengthBeforeInsertion) {
            arr = (int[]) insertedAtEndResult[1];
        }
        System.out.println(String.format("Key %d inserted at %d", 32, (int) insertedAtEndResult[0]));
        printArray(arr);

        // Insert at index
        arr = insertAtIndex(arr, 5, 23);
        System.out.println(String.format("Key %d inserted at %d", 23, 5));
        printArray(arr);

        // Deletion
        System.out.println(String.format("Key %d deleted at %d", 34, deletion(arr, 34)));
        printArray(arr);
    }

    // Traversal
    private static void printArray(int[] arr) {
        System.out.println(
            IntStream.of(arr)
                .mapToObj(String::valueOf)
                .reduce((a, b) -> a + " " + b)
                .orElse("")
        );
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
        int mid = l + (r - l) / 2;
        if (ar[mid] == key) {
            return mid;
        }
        if (ar[mid] > key) {
            return binarySearch(ar, l, mid - 1, key);
        } else {
            return binarySearch(ar, mid + 1, r, key);
        }
    }

    private static Object[] insertAtEnd(int[] ar, int endIndex, int key) throws ArrayIndexOutOfBoundsException {
        if (endIndex + 1 >= ar.length) {
            int[] temp = new int[ar.length * 2];
            System.arraycopy(ar, 0, temp, 0, ar.length);
            System.out.print("New Array: ");
            System.out.println(Arrays.toString(temp));
            ar = temp.clone();
            // throw new ArrayIndexOutOfBoundsException();
        }
        ar[endIndex + 1] = key;
        return new Object[] {endIndex + 1, ar};
    }

    private static int[] insertAtIndex(int[] ar, int index, int key) {
        if (index >= ar.length) {
            int[] temp = new int[ar.length * 2];
            System.arraycopy(ar, 0, temp, 0, ar.length);
            System.out.print("New Array: ");
            System.out.println(Arrays.toString(temp));
            ar = temp.clone();
            // throw new ArrayIndexOutOfBoundsException();
        }
        for (int i = ar.length-1; i > index; i--) {
            ar[i] = ar[i-1];
        }
        ar[index] = key;
        return ar;
    }

    // Deletion
    private static int deletion(int[] arr, int key) {
        int keyLoc = linearSearch(arr, key);
        if (keyLoc == -1) {
            System.out.println(String.format("Key %d not found", key));
            return -1;
        }
        for (int i = keyLoc; i < arr.length-1; i++) {
            arr[i] = arr[i+1];
        }
        return keyLoc;
    }
}