package Data_Structures.Assignments.Assignment_6;

import java.util.Arrays;

//Name: Devin Diaz
//Time: April. 21, 2024
//Class: Data Structures
//Instructor: Jeff Gao
/*Pledge: I, Devin Diaz, did not receive any help for this
programming assignment.*/

/*
    This Java program implements the HeapSort algorithm to sort an array of integers. The HeapSort algorithm
    comprises two main phases:
        1. Building a min-heap from the input array.
        2. Sorting the array using the heap properties.

    The heap is constructed using a heapify process, which ensures that each subtree adheres to the min-heap property
    where each parent node is less than or equal to its child nodes. The heapification starts from the middle of the
    array to the top, as nodes beyond the middle are leaves and inherently satisfy the heap property.
    After constructing the min-heap, the elements are sorted by repeatedly removing the root of the heap, swapping it
    with the last element, and then re-heapifying the remaining elements. The heapify process is applied from the root
    downwards, ensuring the min-heap property is maintained after each extraction.

    This implementation details both the heap construction and the sort mechanism, emphasizing clarity and efficiency
    in the manipulation of heap properties.
*/

public class HeapSort {

    public static void main(String[] args) {
        int[] array = {32, 41, 5, 8, 9, 10, 35, 90, 78, 11, 6, 1};
        System.out.println("ARRAY BEFORE HEAP SORT: ");
        printArray(array);

        heapSort(array);

        System.out.println("ARRAY AFTER HEAP SORT: ");
        printArray(array);
        System.out.println("\n  **HORIZONTAL PRINTED HEAP**");

        printHeapHorizontal(array, 0, "");



    }

    private static void printHeapHorizontal(int[] tree, int i, String prefix) {
        if (i < tree.length) {
            printHeapHorizontal(tree, 2 * i + 2, prefix + "        ");
            System.out.println(prefix + tree[i]);
            printHeapHorizontal(tree, 2 * i + 1, prefix + "        ");
        }
    }


//    public static void printHeapVertically(int[] tree, int i, String prefix) {
//        if (i < tree.length) {
//            printHeapHorizontal(tree, 2 * i + 2, prefix + "\n\n");
//            System.out.print(prefix + tree[i]);
//            printHeapHorizontal(tree, 2 * i + 1, prefix + "\n\n        ");
//        }
//    }


    private static void heapSort(int[] array) {
        int length = array.length;
        for(int i = length / 2 - 1; i >= 0; i--) {
            heapify(array, length, i);
        }

        for(int i = length - 1; i >= 0; i--) {
            swap(array, 0, i);
            heapify(array, length, i);
        }
    }

    private static void heapify(int[] array, int length, int i) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if(left < length && array[left] < array[smallest]) {
            smallest = left;
        }

        if(right < length && array[right] < array[smallest]) {
            smallest = right;
        }

        if(smallest != i) {
            swap(array, i, smallest);
            heapify(array, length, smallest);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void printArray(int[] array) {
        System.out.println(Arrays.toString(array) + "\n");
    }

}
