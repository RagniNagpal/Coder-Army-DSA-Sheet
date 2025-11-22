package Graph;
import java.util.*;

//undirected unweighted
public class Adjmat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int vertex = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int edges = sc.nextInt();
        int[][] adj=new int[vertex][vertex];
        for(int i=0;i<edges;i++){
            int v=sc.nextInt();
            int u=sc.nextInt();
            adj[u][v]=1;
            adj[v][u]=1;
        }
        for(int i=0;i<vertex;i++){
            for(int j=0;j<vertex;j++){
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }

    }
}
