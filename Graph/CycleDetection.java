package Graph;

import java.util.*;

class Pair {

    int first, second;

    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

public class CycleDetection {

    static boolean bfsDetection(int node, ArrayList<ArrayList<Integer>> graph, boolean isVisited[]){
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(node, -1));
        isVisited[node] = true;

        while(!queue.isEmpty()){
            Pair cur = queue.remove();
            int curNode = cur.first; 
            int parent = cur.second; 
            for(int adjacentNode: graph.get(curNode)){
                if(!isVisited[adjacentNode]){
                    isVisited[adjacentNode] = true;
                    queue.add(new Pair(adjacentNode, curNode));
                }else if(adjacentNode != parent) {
                    return true;
                }
            }
        }

        return false;

    }

    static boolean dfsDetection(int node, ArrayList<ArrayList<Integer>> graph, int parent, boolean isVisited[]){

        isVisited[node] = true;

        for(int adjacentNode: graph.get(node)){
            if(!isVisited[adjacentNode]){
                if(dfsDetection(adjacentNode, graph, node, isVisited)) return true;
            }else if(adjacentNode != parent) {
                return true;
            }
        }

        return false;

    }

    static boolean checkCycle(int V, ArrayList<ArrayList<Integer>> graph){

        boolean isVisited[] = new boolean[V];

        for(int i = 0; i < V; i++){
            if(!isVisited[i]){
                if(bfsDetection(i, graph, isVisited)) return true;
                // if(dfsDetection(i, graph, -1, isVisited)) return true;
            }
        }

        return false;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int n = sc.nextInt(), e = sc.nextInt();

        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i =0; i < e; i++){
            int u = sc.nextInt(),  v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean ans = checkCycle(n, graph);
        System.out.println(ans);

    }
    
}