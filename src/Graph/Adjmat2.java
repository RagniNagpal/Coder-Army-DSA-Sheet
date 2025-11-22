package Graph;
import java.util.*;

public class Adjmat2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Input vertices & edges
        System.out.print("Enter number of vertices and edges: ");
        int vertex = sc.nextInt();
        int edges = sc.nextInt();

        // Step 2: Create adjacency matrix (vertex x vertex) initialized with 0
        int[][] adjMat = new int[vertex][vertex];

        // Step 3: Take edges input (u, v, wt)
        System.out.println("Enter edges with weights (u v wt): ");
        for (int i = 0; i < edges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int wt = sc.nextInt();

            // Undirected graph → update both directions
            adjMat[u][v] = wt;
            adjMat[v][u] = wt;
        }

        // Step 4: Print adjacency matrix
        System.out.println("\nAdjacency Matrix:");
        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < vertex; j++) {
                System.out.print(adjMat[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
