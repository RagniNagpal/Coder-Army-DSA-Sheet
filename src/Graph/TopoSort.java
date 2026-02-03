package Graph;
import java.util.*;
public class TopoSort {

        public ArrayList<Integer> topoSort(int V, int[][] edges) {

            // adjacency list
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());   // FIX: earlier you wrote adj.add(i)
            }

            // fill graph
            for (int[] e : edges) {
                int u = e[0], v = e[1];
                adj.get(u).add(v);
            }

            boolean[] visited = new boolean[V];
            Stack<Integer> stack = new Stack<>();

            // DFS call for each component
            for (int i = 0; i < V; i++) {
                if (!visited[i]) {
                    dfs(i, visited, stack, adj);
                }
            }

            // preparing result
            ArrayList<Integer> topOrder = new ArrayList<>();
            while (!stack.isEmpty()) {
                topOrder.add(stack.pop());
            }
            return topOrder;
        }

        // DFS
        public void dfs(int node, boolean[] visited, Stack<Integer> stack,
                        ArrayList<ArrayList<Integer>> adj) {

            visited[node] = true;

            for (int nei : adj.get(node)) {
                if (!visited[nei]) {
                    dfs(nei, visited, stack, adj);
                }
            }

            // push after exploring all neighbors
            stack.push(node);
        }


}
