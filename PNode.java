class PNode {
    int passenger_id;
    int bag_weight;
    PNode next;

    PNode(int passenger_id, int bag_weight) {
        this.passenger_id = passenger_id;
        this.bag_weight = bag_weight;
        this.next = null;
    }
}