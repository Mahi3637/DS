class BNode {
    int value;
    int row_index;
    int column_index;
    BNode next;

    BNode(int value, int row_index, int column_index) {
        this.value = value;
        this.row_index = row_index;
        this.column_index = column_index;
        this.next = null;
    }
}