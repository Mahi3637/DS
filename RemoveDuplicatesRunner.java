//STACK PRACTISE FOR MID
class Stack {
    private static class Node {
        private char data;
        private Node next;

        private Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top;

    public Stack() {
        this.top = null;
    }

    public void push(char value) {
        Node newNode = new Node(value);
        newNode.next = this.top;
        this.top = newNode;
    }

    public char pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        char value = this.top.data;
        this.top = this.top.next;
        return value;
    }

    public char peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return this.top.data;
    }

    public boolean isEmpty() {
        return this.top == null;
    }
}

public class RemoveDuplicatesRunner {

    static String removeDuplicates(String s) {
        // TODO

        Stack tempStack = new Stack();

        for(int i = 0 ; i < s.length(); i++){
            char ch = s.charAt(i);
            if(!tempStack.isEmpty() && tempStack.peek() == ch){
                tempStack.pop();
            }
            else{
                tempStack.push(ch);
            }
        }
        while (!tempStack.isEmpty()) {

        }
        return "";
    }

    public static void main(String[] args) {
        String example1 = "abbaca";
        System.out.println("Example 1 result: " + removeDuplicates(example1)); // Expected: "ca"

        String example2 = "azxxzy";
        System.out.println("Example 2 result: " + removeDuplicates(example2)); // Expected: "ay"
    }
}



// Tracing "abbaca" Iteration by Iteration
// Before the loop (Stack tempStack = new Stack();)

// tempStack is empty (isEmpty() is true).

// Iteration 1 (i = 0, current = 'a')

// !tempStack.isEmpty() is false (because it's empty).

// Because it's && (short-circuit AND), Java stops right there—it does not call tempStack.peek().

// Execution jumps to else → tempStack.push('a').

// Now tempStack has a on top.

// Iteration 2 (i = 1, current = 'b')

// !tempStack.isEmpty() is true (it has 'a').

// tempStack.peek() == 'b' checks 'a' == 'b', which is false.

// Execution jumps to else → tempStack.push('b').

// Now tempStack has b, with a below it.

// Iteration 3 (i = 2, current = 'b')

// !tempStack.isEmpty() is true (it has 'b' and 'a').

// tempStack.peek() == 'b' checks 'b' == 'b', which is true!

// Because 'b' was just pushed in step 3, there is a matching character sitting on top—so instead of pushing a second 'b', it calls tempStack.pop() to cancel the adjacent pair (bb).

// Now tempStack is back to having a on top.

// Iteration 4 (i = 3, current = 'a')

// tempStack.peek() is 'a', which matches current ('a') → tempStack.pop() cancels the aa pair, leaving tempStack empty again.