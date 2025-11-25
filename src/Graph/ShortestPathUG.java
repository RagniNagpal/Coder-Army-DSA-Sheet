package Graph;
import java.util.*;

public class ShortestPathUG {
    class Solution {
        //BFS
        public int[] shortestPath(int V, int[][] edges, int src) {

            // adjacency list
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }

            for (int[] e : edges) {
                int u = e[0];
                int v = e[1];
                adj.get(u).add(v);
                adj.get(v).add(u);   // undirected
            }

            boolean[] visited = new boolean[V];
            int[] dist = new int[V];
            Arrays.fill(dist, -1);

            Queue<Integer> q = new LinkedList<>();
            visited[src] = true;
            dist[src] = 0;
            q.add(src);

            while (!q.isEmpty()) {
                int node = q.poll();

                for (int neighbor : adj.get(node)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        dist[neighbor] = dist[node] + 1;
                        q.add(neighbor);
                    }
                }
            }

            return dist;
        }
    }
//DFS

    public List<Integer> shortestPathDFS(int V, int[][] edges, int src, int dest) {

        // adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u); // undirected
        }

        boolean[] visited = new boolean[V];
        int[] parent = new int[V];
        Arrays.fill(parent, -1);

        dfs(src, adj, visited, parent);

        // Build path using parent[]
        List<Integer> path = new ArrayList<>();
        int curr = dest;

        while (curr != -1) {
            path.add(curr);
            curr = parent[curr];
        }

        Collections.reverse(path);
        return path;
    }

    public void dfs(int node, ArrayList<ArrayList<Integer>> adj,
                    boolean[] visited, int[] parent) {

        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                parent[neighbor] = node; // store parent
                dfs(neighbor, adj, visited, parent);
            }
        }
    }

    public static void main(String[] args) {

    }
}
