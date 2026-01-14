package Graph;

import java.util.*;

public class ShortestDAG {

    public int[] shortestPath(int V, int E, int[][] edges) {

        // Create adjacency list safely
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        // Add edges
        for (int i = 0; i < E; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            adj.get(u).add(new int[]{v, w});
        }

        // Topological Sort
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < V; i++)
            if (!vis[i])
                topoDFS(i, vis, st, adj);

        // Distance array
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;   // source = 0

        // Relax edges in topo order
        while (!st.isEmpty()) {
            int u = st.pop();

            if (dist[u] != Integer.MAX_VALUE) {
                for (int[] e : adj.get(u)) {
                    int v = e[0], w = e[1];
                    if (dist[v] > dist[u] + w)
                        dist[v] = dist[u] + w;
                }
            }
        }

        // IMPORTANT FIX → unreachable nodes = -1
        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                dist[i] = -1;
        }

        return dist;
    }

    private static void topoDFS(int node, boolean[] vis,
                                Stack<Integer> st,
                                List<List<int[]>> adj) {

        vis[node] = true;

        for (int[] e : adj.get(node)) {
            int next = e[0];
            if (!vis[next])
                topoDFS(next, vis, st, adj);
        }

        st.push(node);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();   // number of nodes
        int E = sc.nextInt();   // number of edges

        int[][] edges = new int[E][3];

        for (int i = 0; i < E; i++) {
            edges[i][0] = sc.nextInt();  // u
            edges[i][1] = sc.nextInt();  // v
            edges[i][2] = sc.nextInt();  // weight
        }

        ShortestDAG sol = new ShortestDAG();
        int[] ans = sol.shortestPath(V, E, edges);

        // Print result
        for (int x : ans) {
            System.out.print(x + " ");
        }
    }

}
