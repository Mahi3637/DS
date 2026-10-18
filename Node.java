public class Node {
    public int data;
    Node next;
    Node head;

    Node(int data){
        this.data = data;
        this.next = null;
    }

    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head ==null){
            System.out.println("The list doesnot exixt");
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        if(head == null){
            System.out.println("Doesnt exist");
            return;
        }
        Node currNode = head;
        while(currNode.next != null){
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }

    public void display(){
        Node currNode = head;
        while(currNode != null){
            System.out.print(currNode.data + "----->");
        }
        currNode = currNode.next;
    }

    public static void main(String [] args){
        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);
        Node n4 = new Node(40);
        Node head = n1;
        n1.head = head;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        System.out.println("Print the original List");
        n1.display();
        System.out.println("After prepending");
        n1.addFirst(50);
        n1.display();
        System.out.println("------------------------");
        n1.display();
        System.out.println("After appending");
        n1.addLast(100);
        n1.display();

    }
}
