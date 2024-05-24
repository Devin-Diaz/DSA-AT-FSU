package Analysis_Of_Algorithms.Exercises.Background.Graph_Class_Program;

/**
 * Represents a simple undirected graph using an adjacency matrix.
 * This class provides methods to add and remove edges, check for an edge between two vertices, and print the adjacency matrix.
 */
public class Graph {
    private final int numberOfVertices;  // Number of vertices in the graph
    private final boolean[][] matrix;    // Adjacency matrix to represent edges

    /**
     * Constructs a new Graph with the specified number of vertices.
     * Initializes the adjacency matrix to the size based on the number of vertices.
     *
     * @param numberOfVertices the number of vertices in the graph
     */
    public Graph(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        matrix = new boolean[numberOfVertices][numberOfVertices];
    }

    /**
     * Adds an edge between the specified vertices in the graph.
     *
     * @param row the starting vertex
     * @param col the ending vertex
     * @throws IllegalAccessException if the specified vertices are not valid
     */
    public void addEdge(int row, int col) throws IllegalAccessException {
        if (row >= 0 && row < numberOfVertices && col >= 0 && col < numberOfVertices) {
            matrix[row][col] = true;
            matrix[col][row] = true;  // Uncomment this for directed graph
        } else {
            throw new IllegalAccessException("Vertex number is not valid.");
        }
    }

    /**
     * Removes an edge between the specified vertices in the graph.
     *
     * @param row the starting vertex
     * @param col the ending vertex
     * @throws IllegalAccessException if the specified vertices are not valid
     */
    public void removeEdge(int row, int col) throws IllegalAccessException {
        if (row >= 0 && row < numberOfVertices && col >= 0 && col < numberOfVertices) {
            matrix[row][col] = false;
            matrix[col][row] = false; // Uncomment this for directed graph
        } else {
            throw new IllegalAccessException("Vertex number is not valid.");
        }
    }

    /**
     * Checks if there is an edge between the specified vertices in the graph.
     *
     * @param row the starting vertex
     * @param col the ending vertex
     * @return true if there is an edge, false otherwise
     * @throws IllegalAccessException if the specified vertices are not valid
     */
    public boolean isEdge(int row, int col) throws IllegalAccessException {
        if (row >= 0 && row < numberOfVertices && col >= 0 && col < numberOfVertices) {
            return matrix[row][col];
        } else {
            throw new IllegalAccessException("Vertex number is not valid.");
        }
    }

    /**
     * Prints the adjacency matrix to the console.
     * Each row represents a vertex and each column represents whether there is a connection to another vertex.
     */
    public void printMatrix() {
        for (int i = 0; i < numberOfVertices; i++) {
            for (int j = 0; j < numberOfVertices; j++) {
                System.out.print((matrix[i][j] ? 1 : 0) + " ");
            }
            System.out.println();
        }
    }

    /**
     * Main method to demonstrate the functionality of the Graph class.
     *
     * @param args command-line arguments (not used)
     * @throws IllegalAccessException if an edge is added between invalid vertices
     */
    public static void main(String[] args) throws IllegalAccessException {
        Graph graph = new Graph(3);
        graph.addEdge(0, 2);
        graph.addEdge(1, 1);
        graph.addEdge(2, 0);
        graph.printMatrix();
        /*
            0 0 1
            0 1 0
            1 0 0
        */
    }
}
