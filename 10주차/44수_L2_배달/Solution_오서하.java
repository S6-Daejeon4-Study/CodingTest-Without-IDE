import java.util.*;

class Solution {
    static class Node implements Comparable<Node>{
        int n, w;
        
        public Node(int n, int w){
            this.n = n;
            this.w = w;
        }
        
        public int compareTo(Node o1){
            return this.w - o1.w;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        int minVer[] = new int[N+1];
        boolean visit[] = new boolean[N+1];
        LinkedList<Node> list[] = new LinkedList[N + 1];
        
        for(int i = 1 ; i < N + 1 ; i++ ){
            list[i] = new LinkedList<>();
        }
        
        for(int i = 0 ; i < road.length ; i++){
            int from = road[i][0];
            int to = road[i][1];
            int weight = road[i][2];
            
            list[from].add(new Node(to, weight));
            list[to].add(new Node(from, weight));
        }
        
           
        for(int i = 1 ; i < N + 1 ; i++ ){
            minVer[i] = Integer.MAX_VALUE;
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        pq.add(new Node(1,0));
        minVer[1] = 0;
        
        while(!pq.isEmpty()){
            Node now = pq.poll();
            
            if(visit[now.n]){
                continue;
            }
            
            visit[now.n] = true;
            
            for(Node iter : list[now.n]){
                
                if(!visit[iter.n] && minVer[iter.n] > minVer[now.n] + iter.w ){
                    minVer[iter.n] = minVer[now.n] + iter.w;
                    pq.add(new Node(iter.n, minVer[iter.n]));
                }
            }
        }
        
          for(int i = 1 ; i < N + 1 ; i++ ){
            // System.out.println(minVer[i]);
              if(minVer[i] <= K) answer ++;
        }       
        return answer;
    }
}