import java.util.Scanner;

public class TwoDArray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the rows: ");
        int rows = sc.nextInt();

        System.out.println("Enter the cols: ");
        int cols = sc.nextInt();

        int[][] mat = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                mat[i][j] = sc.nextInt();
            }

        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                System.out.print(mat[i][j] + " ");
            }

            System.out.println();

        }

        int x = 9;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (mat[i][j] == x) {
                    System.out.println(x + " is found at row " + i + " and col " + j);
                }

            }
        }

        int sum = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                sum += mat[i][j];
            }
        }

        System.out.println("The Sum is " + sum);

        // Find the minimum element out of each of the maximum element of each row

        // Print col wise

        for (int j = 0; j < cols; j++) {
            for (int i = 0; i < rows; i++) {

                System.out.print(mat[i][j]);
            }
            System.out.println();

        }
        System.out.println();
    }
}