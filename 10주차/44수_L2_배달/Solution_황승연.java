import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        LinkedList<Point>[] adjList = new LinkedList[N+1];
        for(int i=1;i<=N;i++){
            adjList[i] = new LinkedList<>();
        }
        for(int i=0;i<road.length;i++){
            int from = road[i][0];
            int to = road[i][1];
            int weight = road[i][2];
            
            adjList[from].add(new Point(to,weight));
            adjList[to].add(new Point(from,weight));
        }
        
        int[] d = new int[N+1];
        boolean[] visited = new boolean[N+1];
        for(int i=1;i<=N;i++){
            d[i]=Integer.MAX_VALUE;
        }
        
        PriorityQueue<Point> pq = new PriorityQueue<>();
        
        pq.offer(new Point(1,0));
        d[1]=0;
        
        while(!pq.isEmpty()){
            Point cur = pq.poll();
            int current = cur.vertex;
            int distance = cur.weight;      //나까지 온 시간
            
            if(visited[current]){
                continue;
            }
            visited[current]=true;
            
            for(Point p:adjList[current]){
                if(!visited[p.vertex] && d[p.vertex]> distance+p.weight){
                    d[p.vertex] = distance+p.weight;
                    pq.offer(new Point(p.vertex,d[p.vertex]));
                }
            }
        }
        
        for(int i=1;i<=N;i++){
            if(d[i]<=K){
                answer++;
            }
        }

        return answer;
    }
    
    static class Point implements Comparable<Point>{
        int vertex;
        int weight;
        public Point(int vertex,int weight){
            this.vertex = vertex;
            this.weight = weight;
        }
        
        public int compareTo(Point o){
            return this.weight-o.weight;
        }
    }
}