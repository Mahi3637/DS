public class PackageHashTableTask {

    static class Node {
        String key;
        String value;
        Node next;

        Node(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    static class HashTable {
        Node[] ht;

        HashTable(int size) {
            this.ht = new Node[size];
        }

        // Helper display method formatted like the sample output
        void display() {
            for (int i = 0; i < ht.length; i++) {
                if (ht[i] != null) {
                    System.out.print("Index " + i + ": ");
                    Node curr = ht[i];
                    boolean first = true;
                    while (curr != null) {
                        if (!first) {
                            System.out.print("          ");
                        }
                        System.out.println(curr.key + " (" + curr.value + ")");
                        first = false;
                        curr = curr.next;
                    }
                }
            }
        }

        public int hashFunction(String key) {
            // To do
            String str = "";
            int sum = 0;
            int index = sum % ht.length;

            for (int i = 0; i < key.length(); i++) {
                char c = str.charAt(i);
                int asciiVal = c; // or (int) c
                sum += asciiVal;
                //System.out.println(c + " -> " + asciiVal);
            }
            return index ;
        }

        public void insert(String key, String value) {
            // To do
            int idx = hashFunction(key);

            if(idx < 0 || idx > ht.length){
                System.out.println("isjdvh");
                return;
            }
            Node curr = ht[idx];

            while(curr != null){
                if(curr.key.equals(key)){
                    curr.value = value;
                    return;
                }
                curr = curr.next;
            }
            Node newNode = new Node(key, value);
            newNode.next = ht[idx];
            ht[idx] = newNode;
        }
    }

    public static void main(String[] args) {
        HashTable ht = new HashTable(10);
        ht.insert("PKG123", "In Transit");
        ht.insert("AB", "Delivered");
        ht.insert("PKG456", "Returned");
        System.out.println("Hash table after insertions:");
        ht.display();

        // Updating PKG123 status
        ht.insert("PKG123", "Delivered");
        System.out.println("\nHash table after updates:");
        ht.display();
    }
}