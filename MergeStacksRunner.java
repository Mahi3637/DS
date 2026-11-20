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

public class MergeStacksRunner {

    static Stack mergeStacks(Stack stack1, Stack stack2) {
        // TODO
        Stack tempStack = new Stack();

        while(!stack1.isEmpty() && !stack2.isEmpty()){
            stack1.peek();
            stack2.peek();

            if(stack1.peek() == stack2.peek() || stack1.peek() < stack2.peek()){
                tempStack.push(stack1.pop());
            }
            else{
                tempStack.push(stack2.pop());
            }
        }

        while(!stack1.isEmpty()){
            tempStack.push(stack1.pop());
        }

        while(!stack2.isEmpty()){
            tempStack.push(stack2.pop());
        }
        Stack resulStack = new Stack ();

        while(!tempStack.isEmpty()){
            resulStack.push(tempStack.pop());
        }

        return resulStack;
    }

    public static void main(String[] args) {
        Stack stack1 = new Stack();
        Stack stack2 = new Stack();

        // Example values from prompt (leftmost is top): -2, 3, 6, 6, 10[cite: 1]
        int[] s1 = {-2, 3, 6, 6, 10};
        for (int i = s1.length - 1; i >= 0; i--) {
            stack1.push(s1[i]);
        }

        // Example values from prompt (leftmost is top): 0, 4, 6, 8[cite: 1]
        int[] s2 = {0, 4, 6, 8};
        for (int i = s2.length - 1; i >= 0; i--) {
            stack2.push(s2[i]);
        }

        Stack merged = mergeStacks(stack1, stack2);

        while (merged != null && !merged.isEmpty()) {
            System.out.print(merged.pop());
            if (!merged.isEmpty()) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}