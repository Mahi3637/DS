//232
class IntStack {
    private static class Node {
        private int data;
        private Node next;

        private Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top;

    public IntStack() {
        this.top = null;
    }

    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = this.top;
        this.top = newNode;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        int value = this.top.data;
        this.top = this.top.next;
        return value;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return this.top.data;
    }

    public boolean isEmpty() {
        return this.top == null;
    }
}

class MyQueue {
    private IntStack inStack;
    private IntStack outStack;

    public MyQueue() {
        this.inStack = new IntStack();
        this.outStack = new IntStack();
    }

    public void push(int x) {
        // TODO
    }

    public int pop() {
        // TODO
        return 0;
    }

    public int peek() {
        // TODO
        return 0;
    }

    public boolean empty() {
        // TODO
        return true;
    }
}

public class MyQueueRunner {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue: [1]
        myQueue.push(2); // queue: [1, 2]
        System.out.println("peek: " + myQueue.peek());   // Expected: 1
        System.out.println("pop: " + myQueue.pop());     // Expected: 1, queue: [2]
        System.out.println("empty: " + myQueue.empty()); // Expected: false
    }
}