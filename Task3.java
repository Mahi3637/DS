//Before starting to work on this design the Tree in the Tester code 
// Complete the sumOfLeaves method
public class Task3 {

    //===================================TASK#2===================================
    // This method takes only 2 parameters
    // 1st one is root
    // 2nd one is an Integer
    // You'll need to find the path from the root to a node containing the Integer
    // return the path as a String
    
        // TO DO

        
    public static String findPath(BSTNode root, Integer key) {
    String path = "";
    BSTNode curr = root;

    while (curr != null) {
        
        if (path.equals("")) {
            path += curr.elem;
        }
        
        else {
            path += " " + curr.elem;
        }

        
        if (key.equals(curr.elem)) {
            return path; 
        }

        // BST Navigation
        if (key < curr.elem) {
            curr = curr.left;  
        } 
        
        else {
            curr = curr.right; 
        }
    }

    return "No Path Found";
}
        
    }
    //============================================================================


