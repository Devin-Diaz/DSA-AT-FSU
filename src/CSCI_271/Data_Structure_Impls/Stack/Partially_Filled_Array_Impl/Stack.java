package CSCI_271.Data_Structure_Impls.Stack.Partially_Filled_Array_Impl;

/*
    Partially filled array implementation of a Stack data structure. Stack follows the LIFO principle meaning
    elements are Last In, First Out. The following are the operations of the Stack
    push() - inserts element into stack
    pop() - removes the element at the top of the stack
    peek() - returns the element at the top of the stack without removing it
    isEmpty() - checks if stack is empty
    contains() - checks if a certain element is contained in the stack
    size() - returns current size of stack
*/
public class Stack {
    private int[] data;
    private int top;
    private int capacity;

    public Stack() {
        top = 0;
        capacity = 1;
        data = new int[capacity];
    }

    public void push(int element) {
        if(top == data.length) resize();

        data[top++] = element;
    }

    public int pop() {
        return data[--top];
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public int peek() {
        return data[top - 1];
    }

    public int size() {
        return top;
    }

    public boolean contains(int element) {
        for(int i = 0; i < top; i++) {
            if(data[i] == element) return true;
        }
        return false;
    }

    private void resize() {
        int[] temp_data = new int[capacity * 2];

        for(int i = 0; i < top; i++) {
            temp_data[i] = data[i];
        }

        capacity *= 2;
        data = temp_data;
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
