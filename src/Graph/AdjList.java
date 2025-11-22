package Graph;
import java.util.ArrayList;
import java.util.Scanner;

public class AdjList {
//    int V; // number of vertices
//    ArrayList<ArrayList<Integer>> adj; // adjacency list
//
//    // Constructor
//    AdjList(int V) {
//        this.V = V;
//        adj = new ArrayList<>();
//        for (int i = 0; i < V; i++) {
//            adj.add(new ArrayList<>()); // initialize each list
//        }
//    }
//
//    // Add an undirected edge
//    void addEdge(int u, int v) {
//        adj.get(u).add(v); // add v to u's list
//        adj.get(v).add(u); // add u to v's list (because undirected)
//    }
//
//    // Print adjacency list
//    void printGraph() {
//        for (int i = 0; i < V; i++) {
//            System.out.print(i + " -> ");
//            for (Integer neighbor : adj.get(i)) {
//                System.out.print(neighbor + " ");
//            }
//            System.out.println();
//        }
//    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        System.out.print("Enter number of vertices: ");
//        int V = sc.nextInt();
//
//        System.out.print("Enter number of edges: ");
//        int E = sc.nextInt();
//
//        AdjList g = new AdjList(V);
//
//        System.out.println("Enter edges (u v):");
//        for (int i = 0; i < E; i++) {
//            int u = sc.nextInt();
//            int v = sc.nextInt();
//            g.addEdge(u, v);
//        }
//
//        System.out.println("Adjacency List:");
//        g.printGraph();
//        sc.close();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter vertices: ");
        int V = sc.nextInt();
        System.out.print("Enter edges: ");
        int E = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u); // undirected
        }

        System.out.println("Adjacency List:");
        for (int i = 0; i < V; i++) {
            System.out.print(i + " -> ");
            for (int x : adj.get(i))
                System.out.print(x + " ");
            System.out.println();
        }
    }
}
