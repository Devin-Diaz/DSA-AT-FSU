package CSCI_271.Data_Structure_Impls.Stack.Linked_List_Impl;

import CSCI_271.Data_Structure_Impls.Linked_List.Singly_Linked_List.LinkedList;
import CSCI_271.Data_Structure_Impls.Linked_List.Singly_Linked_List.Node;

/*
    Exact replication of the partially filled array implementation of a Stack. However, this time we are using a
    linked list to mimic all operations of a regular set data structure.
*/
public class Stack {
    private final LinkedList list;

    public Stack() {
        list = new LinkedList();
    }

    public void push(int data) {
        list.insertAtTail(data);
    }

    public int pop() {
        return list.removeAtTail();
    }

    public int peek() {
        Node temp = list.head;

        while(temp.next.next != null) {
            temp = temp.next;
        }
        return temp.next.data;
    }

    public int size() {
        return list.size();
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
