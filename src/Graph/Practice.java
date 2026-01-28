package Graph;

import java.util.*;

public class Practice {

    // ==========================
    // 1️⃣ Bitcoin Mining (Coin Change - DP)
    // ==========================
    static long bitcoinMining(int[] Bitcoins, int N, int K) {
        long[] dp = new long[K + 1];
        dp[0] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = Bitcoins[i]; j <= K; j++) {
                dp[j] += dp[j - Bitcoins[i]];
            }
        }
        return dp[K];
    }

    // ==========================
    // 2️⃣ Count Islands (DFS)
    // ==========================
    static int countIslands(int[][] grid, int m, int n) {
        boolean[][] visited = new boolean[m][n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfs(grid, visited, i, j, m, n);
                    count++;
                }
            }
        }
        return count;
    }

    static void dfs(int[][] grid, boolean[][] visited, int x, int y, int m, int n) {
        if (x < 0 || y < 0 || x >= m || y >= n ||
                grid[x][y] == 0 || visited[x][y]) {
            return;
        }

        visited[x][y] = true;

        dfs(grid, visited, x + 1, y, m, n);
        dfs(grid, visited, x - 1, y, m, n);
        dfs(grid, visited, x, y + 1, m, n);
        dfs(grid, visited, x, y - 1, m, n);
    }

    // ==========================
    // 3️⃣ BFS Traversal
    // ==========================
    public static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        int v = adj.size();
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[v];
        Queue<Integer> q = new LinkedList<>();

        visited[0] = true;
        q.add(0);

        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }
        return ans;
    }

    //DFS
    static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited);
            }
        }
    }

    //Floyd
    // Floyd–Warshall Algorithm
    static final int INF = (int)1e8;

    public static void floydWarshall(int[][] dist) {
        int n = dist.length;

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    // important check
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        dist[i][j] = Math.min(dist[i][j],
                                dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
    }
    // Cycle detection in undirected graph
    public static boolean DFS(int node, ArrayList<ArrayList<Integer>> adj,
                              boolean[] visited, int parent) {

        visited[node] = true;

        for (int neighbor : adj.get(node)) {

            // If neighbor not visited, recurse
            if (!visited[neighbor]) {
                if (DFS(neighbor, adj, visited, node)) {
                    return true;
                }
            }
            // If neighbor is visited and not parent → cycle found
            else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }

    // Function to check cycle in whole graph
    public static boolean isCyclic(ArrayList<ArrayList<Integer>> adj) {
        int v = adj.size();
        boolean[] visited = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                if (DFS(i, adj, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    //topological sort
    public static void dfs(int node,boolean[] visited,Stack<Integer> st,ArrayList<ArrayList<Integer>> adj){
        visited[node]=true;
        for(int neighbor : adj.get(node)){
            if(!visited[neighbor]){
                dfs(neighbor,visited,st,adj);
            }
        }
        st.push(node);
    }
    public static ArrayList<Integer> topoSort(int v,ArrayList<ArrayList<Integer>> adj){
        boolean[] visited=new boolean[v];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<v;i++){
            if(!visited[i]){
                dfs(i,visited,st,adj);
            }
        }
        ArrayList<Integer> topo=new ArrayList<>();
        for(int i=0;i<v;i++){
            topo.add(st.pop());
        }
        return topo;
    }
    // ==========================
    // 4️⃣ MAIN METHOD
    // ==========================
    public static void main(String[] args) {

        // ---- BFS Graph Example ----
        int v = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(3);
        adj.get(1).add(4);

        ArrayList<Integer> bfsResult = bfs(adj);
        System.out.print("BFS Traversal: ");
        for (int node : bfsResult) {
            System.out.print(node + " ");
        }

        // ---- Island Count Example ----
        int[][] grid = {
                {1, 1, 0, 0},
                {1, 0, 0, 1},
                {0, 0, 1, 1},
                {0, 0, 0, 0}
        };

        System.out.println("\nIslands Count: " + countIslands(grid, 4, 4));

        // ---- Bitcoin Mining Example ----
        int[] coins = {1, 2, 3};
        System.out.println("Bitcoin Mining Ways: " + bitcoinMining(coins, coins.length, 4));
        boolean[] visited = new boolean[v];

        dfs(0, adj, visited);
    }
}
