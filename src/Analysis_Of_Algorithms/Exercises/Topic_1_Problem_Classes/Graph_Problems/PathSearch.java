package Analysis_Of_Algorithms.Exercises.Topic_1_Problem_Classes.Graph_Problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
    Simple path search is a variation of the path search problem in graph theory. In simple path search, we find a
    path between two vertices such that no vertices and possibly no edges are repeated. Some applications for this
    problem are in routing and navigation systems where you may want to travel from one location to another without
    retracing your steps.

    I'll be using an adjacency list implementation of a Graph for this problem.
*/
public class PathSearch {
    private int numberOfVertices;
    private LinkedList<Integer>[] adjList;

    // Constructor that creates are adjacency list, (Array of LinkedList's of type Integer)
    public PathSearch(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        adjList = new LinkedList[numberOfVertices];
        for(int i = 0; i < numberOfVertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    // Method to add an edge to the graph
    public void addEdge(int v, int w) {
        adjList[v].add(w);
        adjList[w].add(v);
    }

    // Method to perform DFS from a given vertex
    public List<Integer> findPath(int startVertex, int endVertex) {
        boolean[] visited = new boolean[numberOfVertices]; // track visited vertices
        List<Integer> path = new ArrayList<>(); // contains path if it exists

        if(dfs(startVertex, endVertex, visited, path)) {
            return path;
        }

        return Collections.emptyList();
    }

    public boolean dfs(int current, int destination, boolean[] visited, List<Integer> path) {
        visited[current] = true;    // Mark current node as visited
        path.add(current);      // Add current vertex to path

        if(current == destination) return true;     // Found path

        // Recursion for all the vertices adjacent to this vertex
        for(int next : adjList[current]) {
            if(!visited[next]) {
                if(dfs(next, destination, visited, path)) return true;
            }
        }

        // If no path is found, backtrack and remove the current vertex from the path
        path.remove(path.size() - 1);
        visited[current] = false;
        return false;
    }

    public static void main(String[] args) {
        PathSearch graph = new PathSearch(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);

        int startVertex = 0;
        int endVertex = 3;
        List<Integer> path = graph.findPath(startVertex, endVertex);
        if (path.isEmpty()) {
            System.out.println("No path found");
        }
        else {
            System.out.println("Path: " + path);
        }
    }

}
