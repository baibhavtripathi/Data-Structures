package ai.tribty.linkedlist;

import java.util.Iterator;
import java.util.Objects;

public class DynamicLinkedList<T> implements Iterable<T> {
    private class Node<T> {
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
                    ", prev=" + prev +
                    ", next=" + next +
                    '}';
        }
    }
    private int size = 0;
    private Node<T> head = null, tail = null;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(T data) {
        addLast(data);
    }

    public void addLast(T data) {
        if (isEmpty()) {
            head = tail = new Node<>(data, null, null);
        } else {
            tail.next = new Node<>(data, tail, null);
            tail = tail.next;
        }
        size++;
    }

    public void addFirst(T data) {
        if (isEmpty()) {
            head = tail = new Node<>(data, null, null);
        } else {
            head.prev = new Node<>(data,null, head);
            head = head.prev;
        }
        size++;
    }

    public T peekFirst() {
        if (isEmpty())  throw new RuntimeException("Empty Linked List");
        return head.data;
    }

    public T peekLast() {
        if (isEmpty())  throw new RuntimeException("Empty Linked List");
        return tail.data;
    }

    public T removeFirst() {
        if (isEmpty()) throw new RuntimeException("Empty Linked List");
        T temp = head.data;
        head = head.next;
        if (isEmpty()) tail = null;
        else head.prev = null;
        size--;
        return temp;
    }

    public T removeLast() {
        if (isEmpty()) throw new RuntimeException("Empty Linked List");
        T temp = tail.data;
        tail = tail.prev;
        if (isEmpty()) head = null;
        else tail.next = null;
        size--;
        return temp;
    }

    public boolean remove(Node<T> removeNode) {
        if (isEmpty()) throw new RuntimeException("Empty Linked List");
        else {
            if (removeNode.prev == null) removeFirst();
            else if (removeNode.next == null) removeLast();
//            Node<T> temp = head;
//            while (temp.next != null) {
//
//            }
            (removeNode.prev).next = removeNode.next;
            (removeNode.next).prev = removeNode.prev;
            size--;
            removeNode.prev = removeNode.next = null;
            removeNode.data = null;
            return true;
        }
    }

    public T removeAt(int index) {
        int length = size();
        Objects.checkIndex(index, length);
        Node<T> trav;
        int i;
        if (index < length/2) {
            for (i = 0, trav = head; i <= index; i++) {
                trav = trav.next;
            }
        } else {
            for (i = length, trav = tail; i >= index; i--) {
                trav = trav.prev;
            }
        }
        T data = trav.data;
        remove(trav);
        return data;
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
}
