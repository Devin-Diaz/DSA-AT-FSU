package Data_Structures.Data_Structure_Impls.Queue.Partially_Filled_Array_Impl;

/*
    Partially filled array implementation of a Queue. Queue follows the FIFO principle, First In, First Out.
    The following are the Queues operations:
    enqueue() - inserts element into queue
    dequeue() - removes most element from the front of the queue
    peek() - returns element at the front of the queue
    contains() - checks if an element is contained in the queue
    isEmpty() - checks if queue is empty
    size() - returns size of queue
*/
public class Queue {
    private int[] data;
    private int front;
    private int rear;
    private int capacity;

    public Queue() {
        front = 0;
        rear = 0;
        capacity = 1;
        data = new int[capacity];
    }

    public void enqueue(int element) {
        if(rear == data.length) resize();

        data[rear++] = element;
    }

    public int dequeue() {
        return data[rear++];
    }

    public int peek() {
        return data[front];
    }

    public boolean contains(int element) {
        for(int i = front; i < rear; i++) {
            if(data[i] == element) return true;
        }
        return false;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public int size() {
        return rear - front;
    }

    private void resize() {
        int[] temp_data = new int[capacity * 2];

        for(int i = 0; i < rear - front; i++) {
            temp_data[i] = data[i + front];
        }
        data = temp_data;
        capacity *= 2;
        rear = rear - front;
        front = 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = front; i < rear; i++) {
            sb.append(data[i]).append(" : ");
        }
        sb.deleteCharAt(sb.length() - 2);
        return sb.toString();
    }

}
