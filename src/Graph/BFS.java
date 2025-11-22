package Graph;
import java.util.*;

import java.util.ArrayList;

public class BFS {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj){
        int v=adj.size();
        ArrayList<Integer> res=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        boolean[] visit=new boolean[v];

        visit[0]=true;;
        q.add(0);
        int node;
        while(!q.isEmpty()){
            node=q.poll();
            res.add(node);
            for(int i : adj.get(node)){
                if(!visit[i]){
                    visit[i]=true;
                    q.add(i);
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        BFS bfs=new BFS();
        int v=5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(3);
        adj.get(2).add(4);

        System.out.println("BFS Traversal: " + bfs.bfs(adj));
    }
}
