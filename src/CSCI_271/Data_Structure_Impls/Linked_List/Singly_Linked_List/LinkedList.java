package CSCI_271.Data_Structure_Impls.Linked_List.Singly_Linked_List;

/*
    Implementation of a linked list, made out Nodes taking type integer and a reference node.
    insertAtHead() - inserts node with desired data at the front of the linked list
    insertAtTail() - inserts node with desired data at the end of the linked list
    insertInOrder() - inserts node with desired data in correct position based on the value of data in ascending order
    remove() - removes Node with the data you want to remove from the linked list
    contains() - checks if a node contains data queried for
    isEmpty() - checks if linked list is empty
    size() - returns size of linked list (all current nodes)
    printViaIteration() - displays linked list through iterative process
    printViaRecursion() - displays linked list through recursive process
*/
public class LinkedList {
    public Node head;

    public LinkedList() {
        head = null;
    }

    public void insertInOrder(int data) {
        if(head == null || data <= head.data) insertAtHead(data);

        Node before = head;

        while(before.next != null && before.next.data <= data) {
            before = before.next;
        }

        Node after = before.next;
        before.next = new Node(data);
        before.next.next = after;
    }

    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        newNode.addNext(head);
        head = newNode;
    }

    public void insertAtTail(int data) {
        if(head == null) {
            insertAtHead(data);
            return;
        }

        Node temp = head;

        while(temp.next != null)
            temp = temp.next;

        temp.next = new Node(data);
    }

    public void remove(int data) {
        Node temp = head;

        while(temp.next.data != data) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
    }

    public int removeAtHead() {
        if(head == null) return -1;
        int data = head.data;
        head = head.next;
        return data;
    }

    public int removeAtTail() {
        Node temp = head;

        while(temp.next.next != null) {
            temp = temp.next;
        }
        int data = temp.next.data;
        temp.next = null;
        return data;
    }
    public int size() {
        Node temp = head;
        int counter = 0;

        while(temp != null) {
            counter++;
            temp = temp.next;
        }
        return counter;
    }

    public boolean contains(int data) {
        Node temp = head;
        while(temp != null) {
            if(temp.data == data) return true;
            temp = temp.next;
        }
        return false;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printViaIteration() {
        Node temp = head;

        while(temp != null) {
            System.out.print(temp.data + " ---> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public void printViaRecursion(Node head) {
        if(head == null) {
            System.out.println("NULL");
            return;
        }

        System.out.println(head.data + " --> ");
        printViaRecursion(head.next);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node temp = head;

        while(temp != null) {
            sb.append(temp.data).append(" --> ");
            temp = temp.next;
        }
        sb.append("NULL");
        return sb.toString();
    }

}
