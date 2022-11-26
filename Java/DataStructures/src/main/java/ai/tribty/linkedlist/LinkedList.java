package ai.tribty.linkedlist;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class LinkedList <T> implements Iterable <T> {

    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;

    private class Node <T> {
        T data;
        Node<T> prev, next;

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

    /**
     * Empty Linked List
     */
    public void clear() {
        Node<T> trav = this.head;
        while(trav != null) {
            Node<T> next = trav.next;
            trav.prev = trav.next = null;
            trav.data = null;
            trav = next;
        }
        head = tail = trav = null;
        size = 0;
    }

    /**
     *
     Return Size of LinkedList
      */
    public int size() {
        return size;
    }

    /**
     * Is LinkedList Empty?
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Add an element at end of the linked list
     * @param ele
     */
    public void add(T ele) {
        addLast(ele);
    }


    /**
     * Add an element at the beginning of the linked list
     * @param ele
     */
    public void addFirst(T ele) {
        if (isEmpty()) {
            head = tail = new Node<>(ele, null, null);
        } else {
            head.prev = new Node<>(ele, null, head);
            head = head.prev;
        }
        size++;
    }

    /**
     * Add an element at the end of the linked list
     * @param ele
     */
    public void addLast(T ele) {
        if (isEmpty()) {
            head = tail = new Node<>(ele, null, null);
        } else {
            tail.next = new Node<>(ele, tail, null);
            tail = tail.next;
        }
        size++;
    }

    /**
     * Return First element of the linked list
     * @return Node data
     */
    public T peekFirst() {
        if (isEmpty())  throw new RuntimeException("Empty Linked List");
        return head.data;
    }

    /**
     * Return Last element of the linked list
     * @return Node data
     */
    public T peekLast() {
        if (isEmpty())  throw new RuntimeException("Empty Linked List");
        return tail.data;
    }

    /**
     * Remove first element from Linked List
     * @return node data
     */
    public T removeFirst() {
        // Check for empty list
        if (isEmpty())  throw new RuntimeException("Empty Linked List");
        // Extract data
        T temp = head.data;
        // Move head to next node
        head = head.next;
        // Reduce size of linked list
        size--;
        // Is list empty after removal, if EMPTY tail should be null
        if (isEmpty())  tail = null;
        // Remove Link from first node
        else head.prev = null;
        // return data
        return temp;
    }

    /**
     * Remove Last element from List
     * @return node data
     */
    public T removeLast() {
        // Check list is empty
        if (isEmpty())  throw new RuntimeException("Empty Linked List");
        // Extract data
        T temp = tail.data;
        // Move tail a step back
        tail = tail.prev;
        // Reduce List size
        size--;
        // Is List empty after removal, if YES put head as null
        if (isEmpty())  head = null;
        // Remove link from last node
        else tail.next = null;
        // Return last node data
        return temp;
    }

    /**
     * Remove given object from list
     * @param rm_node
     * @return node data
     */
    public T remove(Node<T> rm_node) {
        // If node to remove is First or Last
        if (rm_node.prev == null)   removeFirst();
        if (rm_node.next == null)   removeLast();

        // If Node is intermediate node in the List
        // Make prev node next as next node
        (rm_node.prev).next = rm_node.next;
        // Make next node previous as previous node
        (rm_node.next).prev = rm_node.prev;
        // Get current node data
        T temp = rm_node.data;
        // Clear memory
        rm_node.data = null;
        rm_node.prev = rm_node.next = null;
        // Reduce List size
        size--;
        // Return node data
        return temp;
    }

    /**
     * Remove element at index 'i' in the list
     * @param index
     * @return node data
     */
    public T removeAt(int index) {
        int size = size();
        if (index < 0 || index >= size)    throw new IllegalArgumentException("Index Out of range");
        Node<T> trav;
        int i;
        if (index < size/2) {
            for (i = 0, trav = head; i != index; i++) {
                trav = trav.next;
            }
        } else {
            for (i = size, trav = tail; i != index; i--) {
                trav = trav.prev;
            }
        }
        return remove(trav);
    }



   /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return null;
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
     * capabilities, is unsized, and does not report any spliterator
     * characteristics. Implementing classes can nearly always provide a
     * better implementation.
     * @since 1.8
     */
    @Override
    public Spliterator<T> spliterator() {
        return Iterable.super.spliterator();
    }
}
