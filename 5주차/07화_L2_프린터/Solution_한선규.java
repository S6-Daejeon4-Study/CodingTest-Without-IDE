import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;
        int size = priorities.length;
        
        
        for(int i = 0; i < size; i++) {
            pq.offer(priorities[i]);
        }
        
        while(!pq.isEmpty()) {
            for(int i = 0; i < size; i++) {
                if(priorities[i] == pq.peek()) {
                    pq.poll();
                    answer++;
                    if(i == location) return answer;
                }
            }
        }       
        
        return answer;
    }
}