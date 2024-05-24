package Data_Structures.Assignments.Assignment_2;

/**
 * The Bag class is a dynamic array structure that allows for storing integers.
 * It provides basic functionalities like add, remove, and check for occurrences,
 * all of which are useful in implementing a lottery system where entries are stored and manipulated.
 */
public class Bag {
    private int[] data;
    private int top;
    private int capacity;

    /**
     * Constructs a new Bag object with initial capacity set to 1.
     */
    public Bag() {
        top = 0;
        capacity = 1;
        data = new int[capacity];
    }

    /**
     * Adds an element to the Bag. If the Bag is full, it resizes to accommodate more elements.
     *
     * @param element The integer to be added.
     */
    public void add(int element) {
        if(top == data.length) resize();
        data[top++] = element;
    }

    /**
     * Removes the first occurrence of the specified element from the Bag.
     * If the element is found, it is removed and elements are shifted.
     *
     * @param element The integer to be removed.
     */
    public void remove(int element) {
        for(int i = 0; i < top; i++) {
            if(data[i] == element) {
                data[i] = data[--top];
                return;
            }
        }
    }

    /**
     * Returns the number of elements in the Bag.
     *
     * @return The size of the Bag.
     */
    public int size() {
        return top;
    }

    /**
     * Counts how many times a specific element appears in the Bag.
     *
     * @param element The integer to count occurrences of.
     * @return The number of times the element occurs.
     */
    public int occurrences(int element) {
        int counter = 0;
        for(int i = 0; i < top; i++) {
            if(data[i] == element) counter++;
        }
        return counter;
    }

    /**
     * Checks if a specific element is present in the Bag.
     *
     * @param element The integer to check for.
     * @return true if the element is found, false otherwise.
     */
    public boolean contains(int element) {
        for(int i = 0; i < top; i++) {
            if(data[i] == element) return true;
        }
        return false;
    }

    /**
     * Checks if the Bag is empty (i.e., contains no elements).
     *
     * @return true if the Bag is empty, false otherwise.
     */
    public boolean isEmpty() {
        return top == 0;
    }

    /**
     * Doubles the capacity of the Bag when it is full to accommodate more elements.
     * This method is called internally by the add method.
     */
    private void resize() {
        int[] temp = new int[capacity *= 2];
        for(int i = 0; i < top; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }
}
