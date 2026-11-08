public class PassengerSorterTester {
    
    // Helper method to print the linked list for testing/debugging
    public static void printLinkedList(PNode head) {
        PNode current = head;
        while (current != null) {
            System.out.print("(" + current.passenger_id + ", " + current.bag_weight + ") ");
            if (current.next != null) {
                System.out.print("-> ");
            }
            current = current.next;
        }
        System.out.println();
    }

    // ==========================================
    // YOUR METHOD TO IMPLEMENT
    // ==========================================
    public static void rearrangePassengers(PNode head) {
        if(head == null){
            System.out.println("No list");
            return;
        }

        PNode current = head;

        while(current.next != null){

            if(current.bag_weight > current.next.bag_weight){
                int tempId = current.passenger_id;
                current.passenger_id = current.next.passenger_id;
                current.next.passenger_id = tempId;

                int tempWeight = current.bag_weight;
                current.bag_weight = current.next.bag_weight;
                current.next.bag_weight = tempWeight;

            }
            current = current.next;
            
        }
    }

    public static void main(String[] args) {
        // Sample test case setup based on the lab sheet: (1,23) -> (2,13) -> (3,18) -> (4,35) -> (5,27)[cite: 1]
        PNode head = new PNode(1, 23);
        head.next = new PNode(2, 13);
        head.next.next = new PNode(3, 18);
        head.next.next.next = new PNode(4, 35);
        head.next.next.next.next = new PNode(5, 27);

        System.out.println("Original Linked List:");
        printLinkedList(head);

        // Calling your method
        rearrangePassengers(head);

        System.out.println("After Rearranging:");
        printLinkedList(head);
    }
}