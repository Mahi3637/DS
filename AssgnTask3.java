//Assignment Task 03: Game Arena
class AssgnTask3{

    //Complete this method so that it gives the Expected Output
    //YOU ONLY HAVE TO SUBMIT THIS METHOD, NO OTHER DRIVER CODE
    public static void playGame( Integer[][] arena ){

        int row = arena.length;
        int col = arena[0].length;
        int sum = 0;

        for(int i = 0; i<arena.length; i++){
            for(int j = 0; j< arena[0].length; j++){
                 
                if(arena[i][j] % 50 == 0 && arena[i][j] != 0){

                    if(arena[i-1][j] == 2){
                        sum += arena[i-1][j];
                    }
                    if(arena[i+1][j] == 2){
                        sum += arena[i+1][j];
                    }
                    if(arena[i][j-1] == 2){
                        sum += arena[i][j-1];
                    }
                    if(arena[i][j+1] ==2 ){
                        sum += arena[i][j+1];
                    }
                }
            }
        }
        System.out.println("The Sum is : "+ sum);

        if(sum<10){
            System.out.println("You lost loser");
        }
        else{
            System.out.println("Your team has survived the game");
        }
    }

    //DO NOT CHANGE ANY DRIVER CODE BELOW THIS LINE
    public static void main(String[] args){
        Integer[][] arena = {
            {2,2,2,0},
            {50,2,2,0},
            {2,2,2,0},
            {2,100,2,0}
        };
        System.out.println("Given Arena: ");
        Arr.print2D(arena);
        
        System.out.println("\nExpected Output:");
        System.out.print("Points Gained: 6. Your team is out.\n");
        
        System.out.print("\nYour Output:\n");
        playGame( arena );

        System.out.print("\n======================\n");

        Integer[][] arena1 = {
            {0,2,2,0,2},
            {1,50,2,1,100},
            {2,2,2,0,2},
            {0,200,2,0,0}
        };
        System.out.println("\nGiven Arena: ");
        Arr.print2D(arena1);
        
        System.out.println("\nExpected Output:");
        System.out.print("Points Gained: 14. Your team has survived the game.\n");
        
        System.out.print("\nYour Output:\n");
        playGame( arena1 );
    }
}

