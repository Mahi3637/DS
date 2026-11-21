public class TextBufferHelper {

    // Given Node class from problem statement[cite: 2]
    static class Node {
        Character[] text;
        Node next;
        Node prev;

        public Node() {
            this.text = new Character[4];
        }
    }

    // Helper methods for building and inspecting the list
    static class BufferListHelper {
        private static final int CAPACITY = 4;

        // Creates and returns a dummy head node (next = null, prev = null)
        static Node createDummyHead() {
            return new Node();
        }

        // Creates a single Node populated with up to 4 characters (remaining slots stay
        // null)
        static Node createNode(String chunk) {
            Node node = new Node();
            if (chunk != null) {
                int limit = Math.min(chunk.length(), CAPACITY);
                for (int i = 0; i < limit; i++) {
                    node.text[i] = chunk.charAt(i);
                }
            }
            return node;
        }

        // Appends an existing Node at the end of a dummy-headed doubly linked list
        static void appendNode(Node dummyHead, Node newNode) {
            if (dummyHead == null || newNode == null) {
                return;
            }
            Node curr = dummyHead;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
            newNode.prev = curr;
            newNode.next = null;
        }

        // Builds a dummy-headed doubly linked list from an array of 4-char (or shorter)
        // block strings
        static Node buildFromBlocks(String... blocks) {
            Node dummyHead = createDummyHead();
            if (blocks == null) {
                return dummyHead;
            }
            for (String block : blocks) {
                appendNode(dummyHead, createNode(block));
            }
            return dummyHead;
        }

        // Prints the list in readable node format and verifies next/prev pointer
        // consistency
        static void printList(String label, Node dummyHead) {
            System.out.println("=== " + label + " ===");
            if (dummyHead == null) {
                System.out.println("null dummyHead");
                return;
            }

            StringBuilder sb = new StringBuilder("DH");
            Node curr = dummyHead.next;
            Node last = dummyHead;

            while (curr != null) {
                if (curr.prev != last) {
                    System.out.println("[WARNING] Broken prev pointer detected!");
                }
                sb.append(" <-> ").append(formatNodeText(curr.text));
                last = curr;
                curr = curr.next;
            }

            System.out.println(sb.toString());

            StringBuilder combined = new StringBuilder();
            Node walker = dummyHead.next;
            while (walker != null) {
                for (int i = 0; i < CAPACITY; i++) {
                    if (walker.text[i] != null) {
                        combined.append(walker.text[i]);
                    }
                }
                walker = walker.next;
            }
            System.out.println("Combined text: \"" + combined.toString() + "\"\n");
        }

        private static String formatNodeText(Character[] text) {
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < CAPACITY; i++) {
                if (i > 0) {
                    sb.append(", ");
                }
                if (text[i] == null) {
                    sb.append("null");
                } else {
                    sb.append("'").append(text[i]).append("'");
                }
            }
            sb.append("]");
            return sb.toString();
        }
    }

    // Target method signature from problem statement[cite: 2]
    static void specialAppend(Node head, String s) {
        // TODO: implement

        if (head == null || s == null || s.isEmpty()) {
            return;
        }
        Node dh = head;
        Node current = dh.next;

        while(current != null){
            current = current.next;
        }
        int idx = 0; 
        int len = s.length();
        
        if(current != head){
            for ( int i = 0; i<4 && idx < len ; i++){
                if(current.text[i] == null){
                    current.text[i] = s.charAt(idx++);
                }
            }
        }
        while(idx < len){
            for(int i = 0; i<4 && idx < len ; i++){
                Node newNode = new Node();
                newNode.text[i] = s.charAt(idx++);
            }
            current.next = newNode;
            newNode.prev = current;
            current = newNode;

        }
    }

    public static void main(String[] args) {
        // Sample 1: DH <-> ['T','r','e','e'] <-> ['_','i','s','_'], append "hard"[cite:
        // 1]
        Node sample1 = BufferListHelper.buildFromBlocks("Tree", "_is_");
        BufferListHelper.printList("Sample 1 Before", sample1);
        specialAppend(sample1, "hard");
        BufferListHelper.printList("Sample 1 After specialAppend(dHead, \"hard\")", sample1);

        // Sample 2: DH <-> ['L','i','s','t'] <-> ['_','E',null,null], append
        // "asier_now"[cite: 1, 2]
        Node sample2 = BufferListHelper.buildFromBlocks("List", "_E");
        BufferListHelper.printList("Sample 2 Before", sample2);
        specialAppend(sample2, "asier_now");
        BufferListHelper.printList("Sample 2 After specialAppend(dHead, \"asier_now\")", sample2);
    }
}