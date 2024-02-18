import java.util.Scanner;

public class DFSTraversal {

    public static void dfs(int[][] graph, int start, boolean[] visited) {
        visited[start] = true;
        System.out.print(start + " ");

        for (int neighbor = 0; neighbor < graph.length; neighbor++) {
            if (graph[start][neighbor] == 1 && !visited[neighbor]) {
                dfs(graph, neighbor, visited);
            }
        }
    }

    public static boolean isConnected(int[][] graph, int startVertex, boolean[] visited) {
        dfs(graph, startVertex, visited);

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int numVertices = scanner.nextInt();

        int[][] adjacencyMatrix = new int[numVertices][numVertices];
        System.out.println("Enter the adjacency matrix (row-wise):");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                adjacencyMatrix[i][j] = scanner.nextInt();
            }
        }

        System.out.print("Enter the starting vertex for DFS traversal: ");
        int startVertex = scanner.nextInt();

        boolean[] visited = new boolean[numVertices]; // Initialize visited array
        System.out.print("DFS Traversal Path: ");
        dfs(adjacencyMatrix, startVertex, visited);
        System.out.println();

        System.out.println("Is the graph connected? " + isConnected(adjacencyMatrix, startVertex, new boolean[numVertices]));

        scanner.close();
    }
}
