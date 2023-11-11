package Graph;

import java.util.*;

public class Traversal {

    static void bfs(ArrayList<ArrayList<Integer>> graph, int root, int n){
        Queue<Integer> queue = new LinkedList<>();
        boolean isVisited[] = new boolean[n+1];
        
        ArrayList<Integer> bfs = new ArrayList<>();
        
        queue.add(root);
        isVisited[root] = true;

        while(!queue.isEmpty()){
            int cur = queue.remove();
            bfs.add(cur);
            for (Integer it : graph.get(cur)) {
                if(!isVisited[it]){
                    isVisited[it] = true;
                    queue.add(it);
                }
            }
        }
        
        System.out.println(bfs);
        
    }

    static void dfs(ArrayList<ArrayList<Integer>> graph, boolean isVisited[], int root, int n){
        isVisited[root] = true;
        
        for(Integer it: graph.get(root)){
            if(!isVisited[it]){
                dfs(graph, isVisited, it, n);
            }
        }
    }
    
}
