package ai.tribty.Array;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @author baibhav.tripathi
 * @apiNote Array Class for dynamic array with Generics
 * @param <T>
 */
@SuppressWarnings("unchecked")
public class Array <T> implements Iterable <T> {
    // members
    private T[] arr;
    private int length;
    private int capacity;

    public Array()  {   this(16);   }

    public Array(int capacity) {
        if (capacity < 0)  throw new IllegalArgumentException("Invalid Capacity: "+capacity);
        this.length = 0;
        this.capacity = capacity;
        this.arr = (T[]) new Object[capacity];
    }

    public int size() { return length; }

    public boolean isEmpty() {  return length == 0;}

    public T get(int index) {   return arr[index]; }

    public void set(int index, T value) { arr[index] = value;}

    public void clear() {
        for (int i = 0; i < length; i++) {
            arr[i] = null;
        }
        length = 0;
    }

    public void add(T element) {
        // Need to re-size
        if (length+1 >= capacity) {
            if (capacity == 0)  capacity = 1;
            else capacity *= 2;
            T[] temp = (T[]) new Object[capacity];
            if (length >= 0) System.arraycopy(arr, 0, temp, 0, length);
            arr =temp;
        }
        arr[length++] = element;
    }

    public T removeAt(int index) {
        if (index >= length || index < 0)   throw new IndexOutOfBoundsException();
        T temp = arr[index];
        T[] arr_temp = (T[]) new Object[length-1];
        for (int i = 0, j = 0; i < length; i++, j++) {
            if (i == index) j--;
            else arr_temp[j] = arr[i];
        }
        capacity = length--;
        arr = arr_temp;
        return temp;
    }

    public boolean remove(T object) {
        for (int i = 0; i < length; i++) {
            if (Objects.equals(arr[i], object)) {
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    public int indexOf(T object) {
        for (int i = 0; i < length; i++) {
            if (Objects.equals(arr[i], object)) return i;
        }
        return -1;
    }

    public boolean contains(T element) { return indexOf(element) != -1;}

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < length;
            }

            @Override
            public T next() {
                return arr[index++];
            }
        };
    }

    /**
     * Performs the given action for each element of the {@code Iterable}
     * until all elements have been processed or the action throws an
     * exception.  Actions are performed in the order of iteration, if that
     * order is specified.  Exceptions thrown by the action are relayed to the
     * caller.
     * <p>
     * The behavior of this method is unspecified if the action performs
     * side effects that modify the underlying source of elements, unless an
     * overriding class has specified a concurrent modification policy.
     *
     * @param action The action to be performed for each element
     * @throws NullPointerException if the specified action is null
     * @implSpec <p>The default implementation behaves as if:
     * <pre>{@code
     *     for (T t : this)
     *         action.accept(t);
     * }</pre>
     * @since 1.8
     */
    @Override
    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action);
    }

    /**
     * Creates a {@link Spliterator} over the elements described by this
     * {@code Iterable}.
     *
     * @return a {@code Spliterator} over the elements described by this
     * {@code Iterable}.
     * @implSpec The default implementation creates an
     * <em><a href="../util/Spliterator.html#binding">early-binding</a></em>
     * spliterator from the iterable's {@code Iterator}.  The spliterator
     * inherits the <em>fail-fast</em> properties of the iterable's iterator.
     * @implNote The default implementation should usually be overridden.  The
     * spliterator returned by the default implementation has poor splitting
     * capabilities, is resized, and does not report any spliterator
     * characteristics. Implementing classes can nearly always provide a
     * better implementation.
     * @since 1.8
     */
    @Override
    public Spliterator<T> spliterator() {
        return Iterable.super.spliterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Array<?> array = (Array<?>) o;
        return length == array.length && capacity == array.capacity && Arrays.equals(arr, array.arr);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(length, capacity);
        result = 31 * result + Arrays.hashCode(arr);
        return result;
    }

    @Override
    public String toString() {
        if (length == 0)    return "[]";
        else {
            StringBuilder sb = new StringBuilder(length).append("[");
            for (T ele : arr) {
                if (ele == arr[length-1])   sb.append(ele).append("]");
                else sb.append(ele).append(", ");
            }
            return sb.toString();
        }
    }
}
