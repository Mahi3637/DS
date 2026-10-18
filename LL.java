public class LL {
    Node head;

    class Node {
        String data;
        Node next;

        Node(String Data) {
            this.data = Data;
            this.next = next;
        }
    }

    // add- first

    public void addFirst(String Data) {
        Node newNode = new Node(Data);
        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    // Add Last

    public void addLast(String Data) {
        Node newNode = new Node(Data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node currNode = head;

        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }

    // Delete First

    public void DeleteFirst() {

        if (head == null) {
            System.out.println("Nah ");
            return;
        }
        head = head.next;
    }

    public void deleteLast() {
        if (head == null) {
            System.out.println("Nah");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Node secondLast = head;
        Node lastNode = head.next;

        while (lastNode.next != null) {
            lastNode = lastNode.next;
            secondLast = secondLast.next;
        }
        secondLast.next = null;
    }

    public void printList() {
        if (head == null) {
            System.out.println("Empty");
            return;
        }

        Node currNode = head;

        while (currNode != null) {
            System.out.print(currNode.data + "--->");
            currNode = currNode.next;
        }

        System.out.println("null");

    }

    public static void main(String[] args) {
        LL list = new LL();
        list.addFirst("1");
        list.addFirst("2");
        list.addFirst("3");
        list.printList();
        list.addLast("3");
        list.addLast("2");
        list.printList();
        list.DeleteFirst();
        list.printList();

    }
}
