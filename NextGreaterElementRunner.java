class IntStack {                                         //496
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

public class NextGreaterElementRunner {

    static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // TODO
        return new int[nums1.length];
    }

    public static void main(String[] args) {
        int[] nums1Ex1 = {4, 1, 2};
        int[] nums2Ex1 = {1, 3, 4, 2};
        int[] res1 = nextGreaterElement(nums1Ex1, nums2Ex1); // Expected: [-1, 3, -1]
        System.out.println("Example 1: " + java.util.Arrays.toString(res1));

        int[] nums1Ex2 = {2, 4};
        int[] nums2Ex2 = {1, 2, 3, 4};
        int[] res2 = nextGreaterElement(nums1Ex2, nums2Ex2); // Expected: [3, -1]
        System.out.println("Example 2: " + java.util.Arrays.toString(res2));
    }
}