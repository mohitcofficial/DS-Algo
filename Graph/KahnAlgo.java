package Graph;
import java.util.*;

public class KahnAlgo {

    static void solve(ArrayList<ArrayList<Integer>> graph, int n){

        int indegree[] = new int[n];
        Queue<Integer> queue = new LinkedList<>();

        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = 0; i < n; i++){
            for(Integer x: graph.get(i)){
                indegree[x]++;
            }
        }

        for(int i = 0; i < n; i++){
            if(indegree[i] == 0) queue.add(i);
        }

        while(!queue.isEmpty()){
            int cur = queue.remove();
            for(Integer x: graph.get(cur)){
                indegree[x]--;
                if(indegree[x] == 0) queue.add(x);
            }
            ans.add(cur);

        }

        if(ans.size() < n) System.out.println("Cycle Present");
        else System.out.println(ans);
        
    }
    
}
