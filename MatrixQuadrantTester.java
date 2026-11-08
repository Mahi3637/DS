public class MatrixQuadrantTester {
    
    // Helper method to print the 2D matrix cleanly for testing/debugging
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    // ==========================================
    // YOUR METHOD TO IMPLEMENT
    // ==========================================
    public static int[][] swapQ1Q4(int[][] matrix) {
        // TODO: Implement your matrix quadrant swapping logic here.
        // Swap elements of Q1 with Q4 while keeping Q2 and Q3 unchanged[cite: 3].

        int row = matrix.length;
        int col = matrix[0].length;

        for(int i = 0; i < row/2; i++){
            for(int j = 0; j < col/2; j++){
              int temp = matrix[i][j];  
              matrix[i][j] = matrix[i+row/2][j+row/2];
              matrix[i+row/2][j+row/2] = temp;
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        // Sample test case setup based on the lab sheet (4x4 matrix)[cite: 3]:
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        System.out.println("Original Matrix:");
        printMatrix(matrix);

        // Calling your method
        matrix = swapQ1Q4(matrix);

        System.out.println("After Swapping Q1 and Q4:");
        printMatrix(matrix);
    }
}