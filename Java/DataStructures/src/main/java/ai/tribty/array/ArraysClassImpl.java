package ai.tribty.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ArraysClassImpl {
    public static void main(String[] args) {
        // Initialize array
        int[] arr = new int[] {6, 9, 7, 2, 3, 3, 9, 4, 0, 4, 5};
        System.out.println("asList() : " + Arrays.asList(6, 9, 7, 2, 3, 3, 9, 4, 0, 4, 5));
        System.out.println("binarySearch() : " + Arrays.binarySearch(new int[] {1, 7 ,5, 3}, 7));
        int[] sarr = new int[] {1, 7 ,5, 3, 2, 4, 5, 6, 8};
        Arrays.sort(sarr);
        System.out.println("binarySearch(arr, fromIndex, toIndex, key, Comparator) : " + 
            Arrays.binarySearch(sarr, 1, 5, 3));
        System.out.println("compare(arr1, arr2) - Lexicographical : " + 
            Arrays.compare(new String[] {"Aman", "Aakash", "Chiti", "Bhumi"}, new String[] {"Aman", "Aakash", "Chiti", "Bhumi"}));
        System.out.println("copyOf(orgArr, newLength) : " + 
            Arrays.toString(Arrays.copyOf(arr, 3)));
        System.out.println("copyOfRange(orgArr, fromIndex, toIndex) : " + 
            Arrays.toString(Arrays.copyOfRange(arr, 4, 6)));
        
        System.out.println("deepEquals(Object[] a1, Object[] a2) : " + 
            Arrays.deepEquals(new String[] {"Aman", "Aakash", "Chiti", "Bhumi"}, new String[] {"Aman", "Aakash", "Chiti", "Bhumi"}));
        System.out.println("deepHashCode(Object[] a) : " + 
            Arrays.deepHashCode(new String[] {"Amanl", "Aakash", "Chiti", "Bhumi"}));
        System.out.println("deepToString(Object[] a) : " + Arrays.deepToString(new Object[] {1, 2, 3}));
        System.out.println("equals(a1, a2) : " + 
            Arrays.equals(arr, arr));
        int[] new_arr = new int[5];
        Arrays.fill(new_arr, 9);
        System.out.println("fill(orgArr, fillValue) : " + Arrays.toString(new_arr));
        
        System.out.println("hashCode(orgArr) : " + 
            Arrays.hashCode(new_arr));
        System.out.println("mismatch(a1, a2) : " + 
            Arrays.mismatch(new_arr, arr));

        int[] temp = Arrays.copyOf(arr, arr.length);
        // System.out.println("parallelPrefix(orgArr, fromIndex, endIndex, functional Operator) : " + 
        //     Arrays.parallelPrefix(temp, null););
        // System.out.println("parallelPrefix(orgArr, Operator) : " + );
        // System.out.println("parllelSetAll(orgArr, functionalGenerator) : " + );
        Arrays.parallelSort(temp);
        System.out.println("parallelSort(orgArr) : " + Arrays.toString(temp));
        
        Arrays.setAll(new_arr, i -> i * 2);
        System.out.println("setAll(orgArr, functionalGenerator) : " + Arrays.toString(new_arr));
        // int[] temp1 = Arrays.copyOf(arr, arr.length);
        // System.out.println("sort(orgArr) : " + Arrays.sort(temp1));
        // int[] temp2 = Arrays.copyOf(arr, arr.length);
        // System.out.println("sort(orgArr, fromIndex, endIndex) : " + Arrays.sort(temp2, 3, 7));
        // int[] temp3 = Arrays.copyOf(arr, arr.length);
        // System.out.println("sort(T[], fromIndex, toIndex, Comparator<super T> c) : " + Arrays.sort(temp3, 2, 7, (a, b) -> b-a));
        
        int intArr[] = { 10, 20, 15, 22, 35 };
        System.out.println("toString(orgArr) : " + Arrays.toString(intArr));
        System.out.println("spliterator(orgArr) : " + Arrays.spliterator(intArr));
        Arrays.spliterator(intArr).forEachRemaining((int t) -> System.out.println(t + 1));
        System.out.println("spliterator(orgArr, fromIndex, endIndex) : " + Arrays.spliterator(intArr, 1, 4));
        System.out.println("stream(orgArr) : " + Arrays.stream(new_arr));
    }
}
