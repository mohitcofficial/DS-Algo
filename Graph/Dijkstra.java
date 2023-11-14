package Graph;

import java.util.*;

class Pair implements Comparable<Pair> {

    int first, second;

    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }

    @Override
    public int compareTo(Pair o) {
        if (this.first != o.first) {
            return this.first - o.first;
        } else {
            return this.second - o.second;
        }
    }
}

public class Dijkstra {

    static ArrayList<ArrayList<Pair>> graph =  new ArrayList<>();
    int N;

    public void initialize(int n, int[][] edges) {
        N=n;
        graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++){
            graph.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
        }
    }

    public int shortestPath(int node1, int node2) {

        PriorityQueue<Pair> queue = new PriorityQueue<Pair>();
        int distance[] = new int[N];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[node1] = 0;

        queue.add(new Pair(0, node1));

        while(!queue.isEmpty()){
            Pair cur = queue.remove();
            int curNode = cur.second, curDistance = cur.first;
            for(int i = 0; i < graph.get(curNode).size(); i++){
                Pair neighbour = graph.get(curNode).get(i);
                int neighbourNode = neighbour.first, neighbourWeight = neighbour.second;
                if(curDistance+neighbourWeight < distance[neighbourNode]){
                    distance[neighbourNode] = curDistance+neighbourWeight;
                    queue.add(new Pair(curDistance+neighbourWeight, neighbourNode));
                }
            }
        }

        if(distance[node2] == Integer.MAX_VALUE) return -1;

        return distance[node2];
        
    }
    
}