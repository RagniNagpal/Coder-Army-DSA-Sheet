package Graph;
import java.util.*;

class Edge{
    int dest;
    int weight;
    Edge(int dest,int weight){
        this.dest=dest;
        this.weight=weight;
    }
}
public class AdjList3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter vertices: ");
        int V = sc.nextInt();
        System.out.print("Enter edges: ");
        int E = sc.nextInt();
        ArrayList<ArrayList<Edge>> adj=new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            adj.get(u).add(new Edge(v, w));
        }
        System.out.println("Adjacency List (Weighted):");
        for (int i = 0; i < V; i++) {
            System.out.print(i + " -> ");
            for (Edge e : adj.get(i))
                System.out.print("(" + e.dest + "," + e.weight + ") ");
            System.out.println();
        }
    }
}
