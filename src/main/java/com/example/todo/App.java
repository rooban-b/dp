package com.example.todo;

/**
 * Hello world!
 *
 */
import java.util.LinkedList;
import java.util.Queue;

public class App{

    // Inner class to represent the Graph
    static class Graph {
        private int vertices; // Number of vertices in the graph
        private LinkedList<Integer>[] adjacencyList; // Adjacency list representation

        // Constructor to initialize the graph
        public Graph(int vertices) {
            this.vertices = vertices;
            this.adjacencyList = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++) {
                this.adjacencyList[i] = new LinkedList<>(); // Initialize each list
            }
        }

        // Method to add an edge to the graph
        public void addEdge(int from, int to) {
            adjacencyList[from].add(to);
            // For an undirected graph, add the reverse edge as well:
            // adjacencyList[to].add(from);
        }

        // Method to perform Breadth-First Search
        public void BFS(int startVertex) {
            // Array to keep track of visited vertices
            boolean[] visited = new boolean[vertices];
            // Queue for BFS traversal
            Queue<Integer> queue = new LinkedList<>();

            // Mark the starting vertex as visited and add it to the queue
            visited[startVertex] = true;
            queue.add(startVertex);

            // Loop until the queue is empty
            while (!queue.isEmpty()) {
                // Dequeue a vertex from the queue
                int currentVertex = queue.poll();
                System.out.print(currentVertex + " "); // Process the current vertex (e.g., print it)

                // Get all adjacent vertices of the dequeued vertex
                // If an adjacent vertex has not been visited, mark it visited and enqueue it
                for (int neighbor : adjacencyList[currentVertex]) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.add(neighbor);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        // Create a graph with 7 vertices
        Graph graph = new Graph(7);

        // Add edges to the graph (example for a directed graph)
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);

        // Perform BFS starting from vertex 0
        System.out.println("Breadth-First Search (BFS) traversal starting from vertex 0:");
        graph.BFS(0); // Output: 0 1 2 3 4 5 6
    }
}