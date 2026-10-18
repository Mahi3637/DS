// Node class for the linked list
class Node {
    String color;
    Node next;
    
    Node(String color) {
        this.color = color;
        this.next = null;
    }
}

// LinkedList class with helper methods
class LinkedList {
    // Create list from array
    public static Node createList(String[] items) {
        if (items == null || items.length == 0) return null;
        
        Node head = new Node(items[0]);
        Node current = head;
        
        for (int i = 1; i < items.length; i++) {
            current.next = new Node(items[i]);
            current = current.next;
        }
        return head;
    }
    
    // Print linked list
    public static void printLL(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.color);
            if (current.next != null) {
                System.out.print(" → ");
            }
            current = current.next;
        }
        System.out.println();
    }
}

public class Assignment1 {
    public static String checksimilar(Node building1, Node building2) {
        // Start from the beginning of both lists
        Node current1 = building1;
        Node current2 = building2;
        
        // Traverse both lists together
        while (current1 != null && current2 != null) {
            // If colors don't match, they're not similar
            if (!current1.color.equals(current2.color)) {
                return "Not Similar";
            }
            // Move to next nodes
            current1 = current1.next;
            current2 = current2.next;
        }
        
        // If one list is longer than the other, they're not similar
        if (current1 != null || current2 != null) {
            return "Not Similar";
        }
        
        // All checks passed
        return "Similar";
    }
    
    public static void main(String[] args) {
        // Test Case 1 - Similar buildings
        System.out.println("==========Test Case 1==============");
        String[] b1 = {"Red", "Green", "Yellow", "Red", "Blue", "Green"};
        Node building_1 = LinkedList.createList(b1);
        String[] b2 = {"Red", "Green", "Yellow", "Red", "Blue", "Green"};
        Node building_2 = LinkedList.createList(b2);
        
        System.out.print("Building 1: ");
        LinkedList.printLL(building_1);
        System.out.print("Building 2: ");
        LinkedList.printLL(building_2);
        
        String returnedValue = checksimilar(building_1, building_2);
        System.out.println("Expected Output: Similar");
        System.out.println("Your Output: " + returnedValue + "\n");
        
        // Test Case 2 - Different colors
        System.out.println("==========Test Case 2==============");
        String[] b3 = {"Red", "Green", "Yellow", "Red", "Yellow", "Green"};
        Node building_3 = LinkedList.createList(b3);
        String[] b4 = {"Red", "Green", "Yellow", "Red", "Blue", "Green"};
        Node building_4 = LinkedList.createList(b4);
        
        System.out.print("Building 1: ");
        LinkedList.printLL(building_3);
        System.out.print("Building 2: ");
        LinkedList.printLL(building_4);
        
        returnedValue = checksimilar(building_3, building_4);
        System.out.println("Expected Output: Not Similar");
        System.out.println("Your Output: " + returnedValue + "\n");
        
        // Test Case 3 - Different lengths
        System.out.println("==========Test Case 3==============");
        String[] b5 = {"Red", "Green", "Yellow", "Red", "Blue", "Green"};
        Node building_5 = LinkedList.createList(b5);
        String[] b6 = {"Red", "Green", "Yellow", "Red", "Blue"};
        Node building_6 = LinkedList.createList(b6);
        
        System.out.print("Building 1: ");
        LinkedList.printLL(building_5);
        System.out.print("Building 2: ");
        LinkedList.printLL(building_6);
        
        returnedValue = checksimilar(building_5, building_6);
        System.out.println("Expected Output: Not Similar");
        System.out.println("Your Output: " + returnedValue + "\n");
    }
}