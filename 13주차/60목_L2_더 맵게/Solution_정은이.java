import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int s : scoville){
            pq.add(s);
        }
        
        int answer = 0;
        while(true){
            if(pq.size()==0){
                answer=-1;
                break;
            }
            if((int)pq.peek()>=K) break;
            if(pq.size()<2){
                answer=-1;
                break;
            }
            int first = pq.poll();
            int second = pq.poll();            
            pq.add(first+2*second);
            
            answer++;
        }
        return answer;
    }
}