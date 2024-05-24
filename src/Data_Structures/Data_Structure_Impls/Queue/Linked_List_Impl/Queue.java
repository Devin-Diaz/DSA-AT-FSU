package Data_Structures.Data_Structure_Impls.Queue.Linked_List_Impl;

import Data_Structures.Data_Structure_Impls.Linked_List.Singly_Linked_List.LinkedList;
import Data_Structures.Data_Structure_Impls.Linked_List.Singly_Linked_List.Node;

/*
    Exact replication of the partially filled array implementation of a Queue. However, this time we are using a
    linked list to mimic all operations of a regular set data structure.
*/
public class Queue {
    private final LinkedList list;

    public Queue() {
        list = new LinkedList();
    }

    public void enqueue(int data) {
        list.insertAtTail(data);
    }

    public int dequeue() {
        return list.removeAtHead();
    }

    public int size() {
        return list.size();
    }

    public int peek() {
        return list.head.data;
    }

    public boolean contains(int data) {
        return list.contains(data);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node temp = list.head;

        while(temp != null) {
            sb.append(temp.data).append(" : ");
            temp = temp.next;
        }
        sb.deleteCharAt(sb.length() - 2);
        return sb.toString();
    }

}
