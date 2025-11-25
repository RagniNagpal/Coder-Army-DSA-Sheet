package Graph;
import java.util.*;

class CycleDetectDG {
    public boolean isCyclic(int V, int[][] edges) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // directed graph → Only u -> v
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
        }

        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];  // recursion stack

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, adj, visited, pathVisited)) return true;
            }
        }
        return false;
    }

    public boolean dfs(int node, ArrayList<ArrayList<Integer>> adj,
                       boolean[] visited, boolean[] pathVisited) {

        visited[node] = true;
        pathVisited[node] = true; // mark in recursion path

        for (int neighbor : adj.get(node)) {

            if (!visited[neighbor]) {
                if (dfs(neighbor, adj, visited, pathVisited))
                    return true;
            }

            else if (pathVisited[neighbor]) {
                return true;   // back-edge found → cycle
            }
        }

        pathVisited[node] = false; // remove from path
        return false;
    }

    // --- Main method for testing ---
    public static void main(String[] args) {
        CycleDetectDG sol = new CycleDetectDG();

        int V = 4;
        int[][] edges = {
                {0, 1},
                {1, 2},
                {2, 3},
                {3, 1}  // cycle exists
        };

        if (sol.isCyclic(V, edges)) {
            System.out.println("Graph contains a cycle");
        } else {
            System.out.println("Graph does NOT contain a cycle");
        }
    }
}



//This Java code detects cycles in a directed graph using Depth-First Search (DFS). It represents the graph as an adjacency list and keeps track of two arrays:
//visited – marks nodes that have been fully processed.
//pathVisited (recursion stack) – marks nodes in the current DFS path to detect back edges.
//The DFS traverses each unvisited node, recursively exploring its neighbors. If a neighbor is already in the current recursion path (pathVisited), a cycle is detected. Otherwise, the node is removed from the recursion stack after processing.
//Time Complexity: O(V + E) – each vertex and edge is visited once.
//Space Complexity: O(V) – for visited arrays and recursion stack.
//This approach efficiently detects cycles in directed graphs and handles both connected and disconnected components.