//Before starting to work on this design the Tree in the Tester code 
// Complete the lowestCommonAncestor method
public class Task2 {

    //======================TASK#1======================
    // This method takes only 3 parameter first one is root
    // and second & third parameter are as 2 integers
    // You'll need to find the lowest common ancestor of them and return it
    public static Integer lowestCommonAncestor( BSTNode root, Integer x, Integer y ){
        // TO DO

        BSTNode predecessor = null;
        BSTNode current = root;

        while(current != null){
            if(x < current.elem){
                current = current.left;
            }

            else if(x > current.elem && y > current.elem){
                current = current.right;
            }
            else{
                return current.elem;
            }
        }
        return x;
    }
}
    //==================================================


