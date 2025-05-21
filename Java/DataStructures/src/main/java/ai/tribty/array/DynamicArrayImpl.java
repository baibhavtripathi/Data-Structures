package ai.tribty.array;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.stream.Stream;

public class DynamicArrayImpl<T> implements Iterable<T> {
    private T[] arr;
    private int len = 0;
    private int capacity = 0;

    public DynamicArrayImpl() {
        this(1);
    }

    public DynamicArrayImpl(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Invalid capacity - " + capacity);
        }
        this.capacity = capacity;
        this.arr = (T[]) new Object[capacity];
    }

    public int size() {
        return len;
    }

    public boolean isEmpty() {
        return len == 0;
    }

    public T get(int index) {
        if (len == 0 || index < 0 || index > len-1) {
            throw new IndexOutOfBoundsException();
        }
        return arr[index];
    }

    public void set(int index, T item) {
        if (len == 0 || index < 0 || index > len-1) {
            throw new IndexOutOfBoundsException();
        }
        arr[index] = item;
    }
 
    public void clear() {
        for (int i = 0; i < capacity; i++) {
            arr[i] = null;
        }
        this.len = 0;
    }

    public void add(T item) {
        if (this.len == this.capacity) {
            resize();
        }
        arr[len] = item;
        len++;
    }

    public T removeAt(int rm_index) {
        if (len == 0 || rm_index < 0 || rm_index > len-1) {
            throw new IndexOutOfBoundsException();
        }
        T itemToRemove = arr[rm_index];
        for (int i = rm_index; i < len-1; i++) {
            arr[i] = arr[i+1];
        }
        arr[len-1] = null;
        len--;
        return itemToRemove;

    }

    private void resize() {
        System.out.println("resize called...");
        if (this.capacity == 0)
            this.capacity = 1;
        else
            this.capacity *= 2;
        T[] tempArray = (T[]) new Object[this.capacity];
        System.arraycopy(arr, 0, tempArray, 0, len);
        this.arr = tempArray.clone();
    }

    public void printArray() throws Exception {
        if (len == 0) {
            throw new Exception("Array is empty");
        }
        for (int i = 0; i < len-1; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(arr[len-1]);
    }


    public static void main(String[] args) throws Exception {
        DynamicArrayImpl<Integer> arr = new DynamicArrayImpl<>();
        System.out.println("Initial size: " + arr.size());
        System.out.println("Is Empty? " + arr.isEmpty());
        arr.add(31);
        arr.add(32);
        arr.add(33);
        arr.add(34);
        System.out.println("Size after insert: " + arr.size());
        arr.printArray();
        System.out.println("Is Empty? " + arr.isEmpty());
        arr.clear();
        System.out.println("Is Empty? " + arr.isEmpty());
        try {
            arr.printArray();
        } catch (Exception e) {
            System.out.println("Error: " + e.getLocalizedMessage());
        }
        arr.add(31);
        arr.add(32);
        arr.add(33);
        arr.add(34);
        System.out.println("Size after insert: " + arr.size());
        arr.printArray();
        System.out.println("Is Empty? " + arr.isEmpty());
    }



    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }
}
