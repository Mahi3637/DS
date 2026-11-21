public class HashtableDeletionTask {

    // Singly linked list node holding an Integer key, String value, and next pointer
    static class Node {
        int key;
        String value;
        Node next;

        Node(int key, String value) {
            this(key, value, null);
        }

        Node(int key, String value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    // Helper class for table creation, hash calculation, insertion, and printing
    static class HashTableHelper {
        static final int CAPACITY = 6;

        static int hash(int key) {
            return (key + 3) % CAPACITY;
        }

        static Node[] createTable() {
            return new Node[CAPACITY];
        }

        // Inserts at the front of the bucket's linked list (forward chaining)
        static void insert(Node[] hashTable, int key, String value) {
            int index = hash(key);
            Node newNode = new Node(key, value);
            newNode.next = hashTable[index];
            hashTable[index] = newNode;
        }

        static void printTable(Node[] hashTable) {
            for (int i = 0; i < hashTable.length; i++) {
                System.out.print(i + ": ");
                Node current = hashTable[i];
                if (current == null) {
                    System.out.println("None");
                    continue;
                }
                while (current != null) {
                    System.out.print("(" + current.key + ", \"" + current.value + "\")");
                    if (current.next != null) {
                        System.out.print(" -> ");
                    }
                    current = current.next;
                }
                System.out.println();
            }
        }
    }

    // TODO: Implement this method to remove the node matching `key` if present
    public static Node[] remove(Node[] hashTable, int key) {
        return hashTable;
    }

    public static void main(String[] args) {
        Node[] hashTable = HashTableHelper.createTable();

        // Sample pairs inserted in order so bucket 1 becomes:
        // (22, "Nilu") -> (4, "Rafi") -> (34, "Abid")
        HashTableHelper.insert(hashTable, 34, "Abid");
        HashTableHelper.insert(hashTable, 4, "Rafi");
        HashTableHelper.insert(hashTable, 6, "Karim");
        HashTableHelper.insert(hashTable, 3, "Chitra");
        HashTableHelper.insert(hashTable, 22, "Nilu");

        System.out.println("Initial HashTable:");
        HashTableHelper.printTable(hashTable);

        System.out.println("\nAfter remove(hashTable, 4):");
        hashTable = remove(hashTable, 4);
        HashTableHelper.printTable(hashTable);

        System.out.println("\nAfter remove(hashTable, 9):");
        hashTable = remove(hashTable, 9);
        HashTableHelper.printTable(hashTable);
    }
}