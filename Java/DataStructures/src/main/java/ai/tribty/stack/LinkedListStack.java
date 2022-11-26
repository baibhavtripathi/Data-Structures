package ai.tribty.stack;

import org.w3c.dom.Node;

import java.util.EmptyStackException;

public class LinkedListStack < E > {
    private Node head;
    private int length;

    protected static class Node < E > {
        E data;
        Node next;
    }

    public LinkedListStack() {
        this.head = null;
        this.length = 0;
    }

    public int size() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void push(E element) {
        Node temp = new Node();
        temp.data = element;
        temp.next = head;
        head = temp;
        length++;
    }

    public E pop() throws EmptyStackException {
        if (head == null) throw new EmptyStackException();
        E temp = (E) head.data;
        head = head.next;
        length--;
        return temp;
    }

    public E peek() throws EmptyStackException {
        if (head == null) throw new EmptyStackException();
        return (E) head.data;
    }

    public static void main(String args[]) throws Exception {
        LinkedListStack mystack = new LinkedListStack();
        mystack.push(9); //a
        mystack.push(3); //b
        mystack.push(8); //c
        System.out.println("Element at the top is :" + mystack.peek()); //d
        System.out.println("Element removed is : " + mystack.pop()); //e
        System.out.println("The size of the stack is : " + mystack.size()); //f
        System.out.println("Element removed is : " + mystack.pop()); //g
        System.out.println("Element at the top is : " + mystack.peek()); //h
        mystack.push(10);
        System.out.println("Stack is empty :  " + mystack.isEmpty()); //i
    }

}
