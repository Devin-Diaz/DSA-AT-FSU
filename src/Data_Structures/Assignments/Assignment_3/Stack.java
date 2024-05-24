package Data_Structures.Assignments.Assignment_3;

public class Stack {
    private char[] data;
    private int top;
    private int capacity;

    public Stack() {
        top = 0;
        capacity = 1;
        data = new char[capacity];
    }

    private void resizeStack() {
        char[] temp = new char[capacity * 2];

        for(int i = 0; i < top; i++) {
            temp[i] = data[i];
        }

        capacity *= 2;

        data = temp;
    }

    public void push(char element) {

        if(data.length - 1 == top) resizeStack();

        data[top++] = element;

    }
    public char pop() {
        return data[--top];
    }

    public char peek() {
        char val = data[--top];
        top++;
        return val;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public void display() {
        StringBuilder s = new StringBuilder();

        s.append("[ ");

        for(int i = 0; i < top; i++) {
            s.append(data[i]).append(", ");
        }

        s.deleteCharAt(s.length() - 2);
        s.deleteCharAt(s.length() - 1);
        s.append(" ]");
        System.out.println(s);
    }
}
