package Graph;
import java.util.*;

public class DFS {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj, int start){
        int v=adj.size();
        ArrayList<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[v];

        dfsHelper(start,adj,visited,res);
        return res;
    }
    public void dfsHelper(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> res){
        visited[node]=true;
        res.add(node);

        for(int i : adj.get(node)){
            if(!visited[i]){
                dfsHelper(i, adj, visited, res);

            }
        }
    }
    public static void main(String[] args) {
        DFS dfs=new DFS();
        int v=5;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(3);
        adj.get(2).add(4);

        System.out.println("DFS Traversal: " + dfs.dfs(adj,0));
    }
}
