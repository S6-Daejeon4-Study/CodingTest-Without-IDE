import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        
        int answer = bfs(scoville, K); 
        
        return answer;
    }
    
    static int bfs(int[] scoville, int K){
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0 ; i < scoville.length ; i++){
            pq.add(scoville[i]);
        }
        
        int time = 1;
        
        while(true){
            int n = pq.poll();
            int m = pq.poll();
            
            int newScoville = n + (m * 2);
            
            pq.add(newScoville);
            
            if(pq.peek() >= K) break;
            if(pq.size() <= 1) return -1;
            time++;
        }
        
        return time;
        
    }
}