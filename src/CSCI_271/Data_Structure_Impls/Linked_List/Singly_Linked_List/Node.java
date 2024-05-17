package CSCI_271.Data_Structure_Impls.Linked_List.Singly_Linked_List;

/*
    Node POJO containing attributes of an int data that stores the value of the node. A Node next that will store
    another type Node. That type node referenced will be the adjacent node in the linked list.
*/
public class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
        next = null;
    }

    public void addNext(Node node) {
        next = node;
    }

}
