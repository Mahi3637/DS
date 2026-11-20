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

public class BackspaceCompareRunner {

    static boolean backspaceCompare(String s, String t) {
        // TODO
        Stack tempStack = new Stack();
        Stack test1 = new Stack ();
        Stack test2 = new Stack();

        for(int i = 0 ; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '#'){
                test1.push(tempStack.pop());
            }
        }
        for(int j = 0 ; j<t.length(); j++){
            char ch = s.charAt(j);

            if(ch == '#'){
                test2.push(tempStack.pop());
            }
        }
        test1.peek();
        test2.peek();
        if(test1 == test2){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Example 1: " + backspaceCompare("ab#c", "ad#c")); // Expected: true
        System.out.println("Example 2: " + backspaceCompare("ab##", "c#d#")); // Expected: true
        System.out.println("Example 3: " + backspaceCompare("a#c", "b"));    // Expected: false
    }
}


// static boolean backspaceCompare(String s, String t) {
//         Stack stackS = new Stack();
//         Stack stackT = new Stack();

//         for (int i = 0; i < s.length(); i++) {
//             char ch = s.charAt(i);
//             if (ch == '#') {
//                 if (!stackS.isEmpty()) {
//                     stackS.pop();
//                 }
//             } else {
//                 stackS.push(ch);
//             }
//         }

//         for (int j = 0; j < t.length(); j++) {
//             char ch = t.charAt(j);
//             if (ch == '#') {
//                 if (!stackT.isEmpty()) {
//                     stackT.pop();
//                 }
//             } else {
//                 stackT.push(ch);
//             }
//         }

//         while (!stackS.isEmpty() && !stackT.isEmpty()) {
//             if (stackS.pop() != stackT.pop()) {
//                 return false;
//             }
//         }

//         return stackS.isEmpty() && stackT.isEmpty();
//     }