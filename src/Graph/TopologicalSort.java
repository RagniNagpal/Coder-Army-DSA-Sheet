package Graph;
import java.util.*;

public class TopologicalSort {
    static void dfs(int node, boolean[] visited, Stack<Integer> stack,List<List<Integer>> adj){
        visited[node]=true;
        for(int neighbor : adj.get(node)){
            if(!visited[neighbor]){
                dfs(neighbor, visited, stack,adj);
            }
        }
        stack.push(node);
    }
    static List<Integer> topologicalSort(int v, List<List<Integer>> adj){
        boolean[] visited=new boolean[v];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<v;i++){
            if(!visited[i]){
                dfs(i,visited,stack,adj);
            }
        }
        List<Integer> topOrder=new ArrayList<>();
        while(!stack.isEmpty()){
            topOrder.add(stack.pop());
        }
        return topOrder;
    }
    public static void main(String[] args) {

    }
}
