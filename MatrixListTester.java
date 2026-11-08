public class MatrixListTester {
    
    // Helper method to print the dummy-headed linked list for testing/debugging
    public static void printLinkedList(BNode dh) {
        System.out.print("dh ");
        BNode current = dh.next;
        while (current != null) {
            System.out.print("-> (" + current.value + "," + current.row_index + "," + current.column_index + ") ");
            current = current.next;
        }
        System.out.println("-> null");
    }

    // ==========================================
    // YOUR METHOD TO IMPLEMENT
    // ==========================================
    public static BNode buildAndRearrange(int[][] M, int threshold, BNode dh) {
        // TODO: Implement your logic here.
        // 1. Extract positive numbers in row-major order[cite: 5].
        // 2. Create BNode(value, row_index, column_index) for each[cite: 5].
        // 3. Place nodes satisfying `value + (row_index + column_index) > threshold` before others[cite: 5].
        // 4. Preserve relative order within each group[cite: 5].
        // 5. Return the dummy head `dh`[cite: 5].

        int row = M.length;
        int col = M[0].length;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                 int temp = M[i][j];

                 if(temp > 0){
                    BNode Node = new BNode(temp, row, col);
                    BNode curr = dh;
                    BNode current = 
                 }
            }
        }


        return dh;
    }

    public static void main(String[] args) {
        // Sample test case setup based on the lab sheet[cite: 5, 6]:
        int[][] M = {
            {4, -1, 5},
            {0, 3, -2},
            {6, -3, 1}
        };
        int threshold = 6;

        // Creating dummy head
        BNode dh = new BNode(-1, -1, -1);

        System.out.println("Given Matrix and Threshold: threshold = " + threshold);

        // Calling your method
        dh = buildAndRearrange(M, threshold, dh);

        System.out.println("\nResulting Linked List:");
        printLinkedList(dh);
    }
}