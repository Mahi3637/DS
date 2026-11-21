public class PulseListHelper {

    // Given CellNode class from problem statement[cite: 4]
    static class CellNode {
        int val;
        int pulse_radius;
        CellNode next;
        CellNode prev;
    }

    // Helper methods for building, appending, and inspecting a non-dummy doubly
    // linked list
    static class DoublyListHelper {

        // Creates a single CellNode with val and pulse_radius
        static CellNode createNode(int val, int pulseRadius) {
            CellNode node = new CellNode();
            node.val = val;
            node.pulse_radius = pulseRadius;
            return node;
        }

        // Appends a node to the end of a non-dummy doubly linked list and returns the
        // (possibly new) head
        static CellNode append(CellNode head, int val, int pulseRadius) {
            CellNode newNode = createNode(val, pulseRadius);
            if (head == null) {
                return newNode;
            }
            CellNode curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
            newNode.prev = curr;
            return head;
        }

        // Builds a non-dummy doubly linked list from alternating [val, pulse_radius,
        // ...] pairs
        static CellNode buildFromPairs(int... pairs) {
            if (pairs == null || pairs.length == 0) {
                return null;
            }
            if (pairs.length % 2 != 0) {
                throw new IllegalArgumentException("pairs must contain (val, pulse_radius) pairs");
            }
            CellNode head = null;
            for (int i = 0; i < pairs.length; i += 2) {
                head = append(head, pairs[i], pairs[i + 1]);
            }
            return head;
        }

        // Prints the list in (val, pulse_radius) format and checks prev pointer
        // consistency
        static void printList(String label, CellNode head) {
            System.out.println("=== " + label + " ===");
            if (head == null) {
                System.out.println("(empty / null head)\n");
                return;
            }
            if (head.prev != null) {
                System.out.println("[WARNING] Head's prev pointer is not null!");
            }

            StringBuilder sb = new StringBuilder();
            CellNode curr = head;
            CellNode expectedPrev = null;

            while (curr != null) {
                if (curr.prev != expectedPrev) {
                    System.out.println(
                            "[WARNING] Broken prev pointer at node (" + curr.val + ", " + curr.pulse_radius + ")!");
                }
                if (curr != head) {
                    sb.append(" <-> ");
                }
                sb.append("(").append(curr.val).append(", ").append(curr.pulse_radius).append(")");
                expectedPrev = curr;
                curr = curr.next;
            }

            System.out.println(sb.toString() + "\n");
        }
    }

    // Target method signature from problem statement[cite: 3]
    public static CellNode sendPulse(CellNode head) {
        // TODO: implement
        if (head == null) {
            return null;
        }
        CellNode current = head;
        int r = current.pulse_radius;
        CellNode left = current.prev;
        CellNode right = current.next;
        while (current != null) {
            if (r > 0) {
                //will do later
            }
        }

        return head;
    }

    public static void main(String[] args) {
        // Sample 1: (5,0) <-> (10,1) <-> (15,0) <-> (20,0) ==> (20, 0)[cite: 4]
        CellNode sample1 = DoublyListHelper.buildFromPairs(
                5, 0,
                10, 1,
                15, 0,
                20, 0);
        DoublyListHelper.printList("Sample 1 Before", sample1);
        CellNode result1 = sendPulse(sample1);
        DoublyListHelper.printList("Sample 1 After sendPulse", result1);

        // Sample 2: (5,0) <-> (10,0) <-> (15,1) <-> (20,1) <-> (25,0) ==> (5, 0) <->
        // (25, 0)[cite: 4]
        CellNode sample2 = DoublyListHelper.buildFromPairs(
                5, 0,
                10, 0,
                15, 1,
                20, 1,
                25, 0);
        DoublyListHelper.printList("Sample 2 Before", sample2);
        CellNode result2 = sendPulse(sample2);
        DoublyListHelper.printList("Sample 2 After sendPulse", result2);
    }
}