package Graph;

import java.util.*;

public class PrerequisiteTasks {
    public boolean canFinish(int N, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<N; i++) graph.add(new ArrayList<>());

        // Build graph
        for(int[] pre : prerequisites){
            int a = pre[0], b = pre[1];
            graph.get(b).add(a); // b -> a
        }

        boolean[] visited = new boolean[N];
        boolean[] recStack = new boolean[N];

        for(int i=0; i<N; i++){
            if(!visited[i]){
                if(dfs(i, graph, visited, recStack)) return false; // cycle found
            }
        }
        return true; // no cycle
    }

    boolean dfs(int node, List<List<Integer>> graph, boolean[] visited, boolean[] recStack){
        visited[node] = true;
        recStack[node] = true;

        for(int neighbor : graph.get(node)){
            if(!visited[neighbor] && dfs(neighbor, graph, visited, recStack))
                return true;
            else if(recStack[neighbor])
                return true;
        }

        recStack[node] = false;
        return false;
    }

    public static void main(String[] args){
        PrerequisiteTasks obj = new PrerequisiteTasks();
        int N = 4;
        int[][] prerequisites = {{1,0},{2,1},{3,2}};
        System.out.println(obj.canFinish(N, prerequisites)); // true
    }
}

