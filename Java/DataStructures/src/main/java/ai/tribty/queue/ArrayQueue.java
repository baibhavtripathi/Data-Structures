package ai.tribty.queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class ArrayQueue < E > {
    private static final int CAPACITY = 10;
    private E[] data;
    private int frontIndex, queueSize;

    public ArrayQueue() { this(CAPACITY); }

    public ArrayQueue(int capacity) {
        frontIndex = queueSize = 0;
        data = (E[]) new Object[capacity];
    }

    public int size() {
        return queueSize;
    }

    public boolean isEmpty() {
        return queueSize == 0;
    }

    public void enqueue(E element) throws IllegalStateException {
        if (queueSize == data.length)   throw new IllegalStateException("Queue is full");
        int insertAt = (frontIndex + queueSize) % data.length;
        data[insertAt] = element;
        queueSize++;
    }

    public E dequeue() throws IllegalStateException {
        if (queueSize == 0) throw new IllegalStateException("Queue is Empty");
        E temp = data[frontIndex];
        data[frontIndex] = null; // dereference to help garbage collection
        frontIndex = (frontIndex + 1) % data.length;
        queueSize--;
        return temp;
    }

    public E first() throws IllegalStateException {
        if (queueSize == data.length) throw new IllegalStateException("Queue is empty");
        return data[frontIndex];
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue();
        queue.enqueue(18); //a
        System.out.println("Element at front :  " + queue.first()); //b
        System.out.println("Element removed from front : " + queue.dequeue()); //c
        System.out.println("Queue is Empty : " + queue.isEmpty()); //d
        queue.enqueue(79); //e
        queue.enqueue(90); //f
        System.out.println("Size of the queue : " + queue.size()); //g
        System.out.println("Element removed from front end : " + queue.dequeue());
        //h
    }

}
