public class CircularListTester {
    
    // Helper method to safely print a circular linked list
    public static void printCircularList(ANode head) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        ANode current = head;
        do {
            System.out.print(current.val + " -> ");
            current = current.next;
        } while (current != head);
        System.out.println("(back to " + head.val + ")");
    }

    // ==========================================
    // YOUR METHOD TO IMPLEMENT
    // ==========================================
    public static ANode reverseOdd(ANode head) {

        if(head == null){
            System.out.println("No list loser");
            return null;
        }

        ANode current = head;

        while(current.next != null){
            
        }
    
        return head;
    }

    public static void main(String[] args) {
        // Sample test case setup based on the lab sheet:
        // 11 -> 21 -> 6 -> 41 -> 56 -> 63 -> (back to 11)[cite: 2]
        ANode head = new ANode(11);
        ANode second = new ANode(21);
        ANode third = new ANode(6);
        ANode fourth = new ANode(41);
        ANode fifth = new ANode(56);
        ANode sixth = new ANode(63);

        // Linking nodes together
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = head; // Completing the circle

        System.out.println("Original Circular Linked List:");
        printCircularList(head);

        // Calling your method
        head = reverseOdd(head);

        System.out.println("After Reversing Odd Values:");
        printCircularList(head);
    }
}