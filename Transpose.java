public class Transpose {
    public static void main(String [] args){

        int mat [][] = {{1,2,3},{4,5,6},{7,8,9}};

         int row = mat.length;
         int col = mat[0].length;

        for(int i = 0; i<row; i++){
            for(int j = 0; j < i; j++){

                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;

            }
            System.out.println("  ");
        }

        for(int i = 0; i<row ; i++){
            for(int j = 0; j< col; j++){
                System.out.print(mat[i][j] + "  ");
            }
            System.out.println("");
        }
    }
}
