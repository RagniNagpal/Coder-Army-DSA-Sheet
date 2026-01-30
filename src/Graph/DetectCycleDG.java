package Graph;
import java.util.*;
public class DetectCycleDG {
    class Solution {
        public boolean isCyclic(int V, int[][] edges) {

            // Create adjacency list
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }

            for (int[] e : edges) {
                int u = e[0], v = e[1];
                adj.get(u).add(v);
            }

            // Build indegree array
            int[] indegree = new int[V];
            for (int i = 0; i < V; i++) {
                for (int nei : adj.get(i)) {
                    indegree[nei]++;
                }
            }

            // Add all 0-indegree nodes to queue
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < V; i++) {
                if (indegree[i] == 0) q.add(i);
            }

            int count = 0;

            // BFS (Kahn’s Algo)
            while (!q.isEmpty()) {
                int top = q.poll();
                count++;

                for (int nei : adj.get(top)) {
                    indegree[nei]--;
                    if (indegree[nei] == 0) {
                        q.add(nei);
                    }
                }
            }

            // If all nodes processed → no cycle
            // If some nodes left → cycle present
            return count != V;
        }
    }

}
