public class Task1 {

    //======================TASK#1a======================
    // This method takes only 1 parameter; root of a BST
    // You'll need to find the max of the BST and return it
    public static BSTNode maxOfBST( BSTNode root ){
        // TO DO

        if (root == null) {
             return null;
        }
        
        BSTNode curr = root;
        // Logic: The largest value is always the right-most node.
        while (curr.right != null) {
            curr = curr.right;
        }
        return root;
    }
       // return null; //remove this line
    
    //==================================================

    //======================TASK#1b======================
    // This method takes only 2 parameters
    // root of a BST and the value of which you wanna the predecessor
    // You'll need to find the max of the BST and return it
    public static BSTNode inOrderPred( BSTNode root, Integer x ){
        // TO DO

        BSTNode curr = root;
        BSTNode predecessor = null;

        while (curr != null) {
            if (x < curr.elem) {
                
                curr = curr.left;
            }
             else if (x > curr.elem) {
                
                predecessor = curr;
                curr = curr.right;
            } 
            else {
                
            
                if (curr.left != null) {
                    return maxOfBST(curr.left);
                }
                break;
            }
        }
        return predecessor;
        
    }
       // return null; //remove this line
}
    //==================================================

