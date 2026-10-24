//Assignment Task 02: Matrix Compression
class AssgnTask2{

    //Complete this method so that it gives the Expected Output
    //YOU ONLY HAVE TO SUBMIT THIS METHOD, NO OTHER DRIVER CODE
    public static Integer[][] compressMatrix( Integer[][] matrix ){

        int row = matrix.length;
        int col = matrix[0].length;
        int comSum = 0;
        int comRow = row/2;
        int comCol = col/2;
        Integer [][] comMat = new Integer[comRow][comCol];
        

        if(row%2 == 0 && col%2 == 0){
            for(int i = 0; i<row; i++){
                for(int j = 0; j<col; j++){
                    comMat[i/2][j/2] += matrix[i][j];
                }
            }
            return comMat;
        }
        else{
            System.out.println("Invalid");
        }
        return comMat;
    }

    //DO NOT CHANGE ANY DRIVER CODE BELOW THIS LINE
    public static void main(String[] args){
        Integer[][] matrix = {
            { 1 , 2 , 3 , 4 },
            { 5 , 6 , 7 , 8 },
            { 1 , 3 , 5 , 2 },
            {-2 , 0 , 6 ,-3 }
        };
        System.out.println("Given Matrix: ");
        Arr.print2D(matrix);
        
        System.out.println("\nExpected Output:");
        System.out.print("| 14 | 22 |\n| 2  | 10 |\n");
        
        System.out.print("\nYour Output:\n");
        Integer[][] returnedArray = compressMatrix( matrix );
        Arr.print2D( returnedArray );
    }
}
