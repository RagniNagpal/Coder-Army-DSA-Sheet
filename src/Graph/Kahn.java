package Graph;
import java.util.*;
public class Kahn {
    class Solution {
        public ArrayList<Integer> topoSort(int V, int[][] edges) {

            // Step 1: Create adjacency list
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

            for (int[] e : edges) {
                int u = e[0], v = e[1];
                adj.get(u).add(v);
            }

            // Step 2: Indegree array
            int[] indegree = new int[V];

            for (int i = 0; i < V; i++) {
                for (int next : adj.get(i)) {
                    indegree[next]++;
                }
            }

            // Step 3: Queue and result
            Queue<Integer> q = new LinkedList<>();
            ArrayList<Integer> result = new ArrayList<>();

            // Push all nodes with indegree 0
            for (int i = 0; i < V; i++) {
                if (indegree[i] == 0) q.add(i);
            }

            // Step 4: BFS
            while (!q.isEmpty()) {
                int node = q.poll();
                result.add(node);

                for (int next : adj.get(node)) {
                    indegree[next]--;
                    if (indegree[next] == 0) {
                        q.add(next);
                    }
                }
            }

            return result;  // topologically sorted order
        }
    }

}
