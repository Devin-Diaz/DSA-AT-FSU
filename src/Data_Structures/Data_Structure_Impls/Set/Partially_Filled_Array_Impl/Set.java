package Data_Structures.Data_Structure_Impls.Set.Partially_Filled_Array_Impl;

/*
    Implementation of a Set using a partially filled array. A set contains ordered unique elements.
    The following are the operations of a Set:
    add() - adds element to set
    remove() - removes element from set
    contains() - checks if a certain element is in set
    isEmpty() - checks if set is empty
    size() - returns size of the current set
    intersection() - returns the set of elements common to two sets being compared
    union() - returns every element from two sets without duplicates
    difference() - returns elements found in one set but not in others
*/
public class Set {
    private int[] data;
    private int top;
    private int capacity;

    public Set() {
        top = 0;
        capacity = 1;
        data = new int[capacity];
    }

    public void add(int element) {
        if(top == data.length) {
            resize();
        }

        if(!contains(element)) data[top++] = element;
    }

    public void remove(int element) {
        for(int i = 0; i < top; i++) {
            if(data[i] == element) {
                data[i] = data[--top];
                return;
            }
        }
    }

    public boolean contains(int element) {
        for(int n : data) {
            if(n == element) return true;
        }
        return false;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    private void resize() {
        int[] temp_data = new int[capacity * 2];

        for(int i = 0; i < top; i++) {
            temp_data[i] = data[i];
        }

        capacity *= 2;
        data = temp_data;
    }

    public int size() {
        return top;
    }

    public static Set intersection(Set A, Set B) {
        return difference(A, difference(A, B));
    }

    public static Set union(Set A, Set B) {
        Set unionSet = new Set();

        for(int i = 0; i < A.top; i++) {
            unionSet.add(A.data[i]);
        }

        for(int i = 0; i < B.top; i++) {
            unionSet.add(B.data[i]);
        }

        return unionSet;
    }

    public static Set difference(Set A, Set B) {
        Set differenceSet = new Set();

        for(int i = 0; i < A.top; i++) {
            differenceSet.add(A.data[i]);
        }

        for(int i = 0; i < B.top; i++) {
            if(A.contains(B.data[i])) {
                differenceSet.remove(B.data[i]);
            }
        }
        return differenceSet;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < top; i++) {
            sb.append(data[i]).append(" : ");
        }
        sb.deleteCharAt(sb.length() - 2);
        return sb.toString();
    }

}
