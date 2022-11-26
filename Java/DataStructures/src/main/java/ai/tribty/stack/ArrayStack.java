package ai.tribty.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack < E > {
    private static final int CAPACITY = 16; // default array capacity
    private int topIndex = -1; // top most / head of the stack index
    private E[] data; // Generic array for storing data of type E

    public ArrayStack() { this(CAPACITY); };

    public  ArrayStack(int capacity) {
        this.topIndex = -1;
        data = (E[]) new Object[capacity];
    }

    public int size() {
        return topIndex + 1;
    }

    public boolean isEmpty() {
        return topIndex == -1;
    }

    public void push(E element) throws IllegalArgumentException {
        if (size() == data.length) throw new StackOverflowError("Stack is full");
        data[++topIndex] = element; // incrementing topIndex before storing new element
    }

    public E pop() throws EmptyStackException {
        if (topIndex == -1) throw new EmptyStackException();
        E temp = data[topIndex];
        data[topIndex--] = null;
        return temp;
    }

    public E peek() throws EmptyStackException {
        if (topIndex == -1) throw new EmptyStackException();
        return data[topIndex];
    }

    @Override
    public String toString() {
        return "ArrayStack" + Arrays.toString(data);
    }

    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        System.out.println("Stack is empty? " + arrayStack.isEmpty());
        System.out.println("Stack size: " + arrayStack.size());
        for (int i = 0; i < 10; i++) {
            arrayStack.push(i);
        }
        System.out.println("Stack is empty? " + arrayStack.isEmpty());
        System.out.println("Stack size: " + arrayStack.size());
        System.out.println("Print Stack: " + arrayStack);
        System.out.println("Top Element index: " + arrayStack.topIndex);

        for (int i = 0; i < 10; i++) {
            System.out.println("Stack head: "+ arrayStack.peek());
            System.out.println("Pop at index '" + i + "' -> " + arrayStack.pop());
        }


    }
}
