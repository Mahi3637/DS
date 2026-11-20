//STACK PRACTISE FOR MID

class Stack {
    private static class Node {
        private int data;
        private Node next;

        private Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top;

    public Stack() {
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

public class BaseballGameRunner {

    static int calPoints(String[] operations) {
        // TODO
        int score = 0;
        Stack tempStack = new Stack();

        for (int i = 0; i < operations.length; i++) {
            if (operations.equals("C")) {
                tempStack.pop();
            } else if (operations.equals("D")) {
                tempStack.push(2 * tempStack.peek());
            } else if (operations.equals("+")) {
                int top1 = tempStack.pop();
                int top2 = tempStack.peek();
                int sum = top1 + top2;
            }
        }

        while (!tempStack.isEmpty()){
            score += tempStack.pop();
        }
        return score;
    }

    public static void main(String[] args) {
        String[] example1 = { "5", "2", "C", "D", "+" };
        System.out.println("Example 1 result: " + calPoints(example1)); // Expected: 30

        String[] example2 = { "5", "-2", "4", "C", "D", "9", "+", "+" };
        System.out.println("Example 2 result: " + calPoints(example2)); // Expected: 27
    }
}