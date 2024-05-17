package CSCI_271.Data_Structure_Impls.Set.Linked_List_Impl;

import CSCI_271.Data_Structure_Impls.Linked_List.Singly_Linked_List.LinkedList;
import CSCI_271.Data_Structure_Impls.Linked_List.Singly_Linked_List.Node;

/*
    Exact replication of the partially filled array implementation of a Set. However, this time we are using a
    linked list to mimic all operations of a regular set data structure.
*/
public class Set {
    private final LinkedList list;

    public Set() {
        list = new LinkedList();
    }

    public void add(int element) {
        if(!contains(element)) list.insertAtTail(element);
    }

    public void remove(int element) {
        list.remove(element);
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public boolean contains(int element) {
        return list.contains(element);
    }

    public static Set union(Set A, Set B) {
        Set unionSet = new Set();
        Node temp = A.list.head;

        while(temp != null) {
            unionSet.add(temp.data);
            temp = temp.next;
        }

        temp = B.list.head;

        while(temp != null) {
            unionSet.add(temp.data);
            temp = temp.next;
        }
        return unionSet;
    }

    public static Set intersection(Set A, Set B) {
        return difference(A, difference(A, B));
    }

    public static Set difference(Set A, Set B) {
        Set differenceSet = new Set();
        Node temp = A.list.head;

        while(temp != null) {
            differenceSet.add(temp.data);
            temp = temp.next;
        }

        temp = B.list.head;

        while(temp != null) {
            differenceSet.remove(temp.data);
            temp = temp.next;
        }

        return differenceSet;
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
