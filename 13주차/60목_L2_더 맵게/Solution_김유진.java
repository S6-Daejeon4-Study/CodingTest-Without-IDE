import java.util.PriorityQueue;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int s : scoville)
            pq.add(s);
        
        int answer = 0;
        while(pq.peek() < K && pq.size() > 1){
            pq.add(pq.poll() + pq.poll()*2);
            ++answer;
        }
        if(pq.peek() < K)
            return -1;
        else
            return answer;
    }
}