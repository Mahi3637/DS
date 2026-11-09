public class RowSumTester {
    
    // Helper method to print the linked list for testing/debugging
    public static void printLinkedList(CNode head) {
        CNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }

    // ==========================================
    // YOUR METHOD TO IMPLEMENT
    // ==========================================
    public static String comparerRowSum(CNode head, int[][] matrix) {
        // TODO: Implement your row sum comparison logic here[cite: 8].
        // 1. Calculate the sum of each row of the matrix sequentially[cite: 8].
        // 2. Compare each sum with the corresponding linked list node value[cite: 8].
        // 3. Return "Matched" if all match, otherwise "Not Matched"[cite: 8].
        return "";
    }

    public static void main(String[] args) {
        // Sample test case 1 setup based on the lab sheet[cite: 8]:
        // Matrix row sums: 
        // Row 0: 1 + 3 + 5 = 9
        // Row 1: 2 + 6 + 8 = 16
        // Row 2: 7 + 4 + 9 = 20
        // Linked list values: 9 -> 16 -> 20 (Should return "Matched")[cite: 8]
        
        CNode head = new CNode(9);
        head.next = new CNode(16);
        head.next.next = new CNode(20);

        int[][] matrix = {
            {1, 3, 5},
            {2, 6, 8},
            {7, 4, 9}
        };

        System.out.println("Linked List:");
        printLinkedList(head);

        // Calling your method
        String result = comparerRowSum(head, matrix);
        System.out.println("Result: " + result);
    }
}