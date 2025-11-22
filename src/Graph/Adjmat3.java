package Graph;
import java.util.*;

public class Adjmat3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int vertex = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int edges = sc.nextInt();
        // adjacency matrix initialize
        int[][] adj=new int[vertex][vertex];
        System.out.println("Enter each edge (u v):");
        for (int i = 0; i < edges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            // directed unweighted graph ke liye dono side 1
            adj[u][v] = 1;
        }
        //print adjacency matrix
        System.out.println("Adjacency Matrix");
        for(int i=0;i<vertex;i++){
            for(int j=0;j<vertex;j++){
                System.out.print(adj[i][j]+" ");
            }
            System.out.println();
        }
    }

    }

