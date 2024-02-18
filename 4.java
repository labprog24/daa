import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS_Digraph {

    private int[][] adjacencyMatrix; // Adjacency matrix representation of the graph

    public BFS_Digraph(int vertices) {
        adjacencyMatrix = new int[vertices][vertices];
    }

    public void breadthFirstSearch(int startVertex) {
        int V = adjacencyMatrix.length; // Number of vertices
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        
        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            System.out.print(currentVertex + " ");

            for (int i = 0; i < V; i++) {
                if (adjacencyMatrix[currentVertex][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();

        BFS_Digraph graph = new BFS_Digraph(vertices);

        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                graph.adjacencyMatrix[i][j] = scanner.nextInt();
            }
        }

        System.out.print("Enter the starting point for BFS traversal: ");
        int startVertex = scanner.nextInt();

        System.out.print("BFS Traversal starting from vertex " + startVertex + ": ");
        graph.breadthFirstSearch(startVertex);

        scanner.close();
    }
}
