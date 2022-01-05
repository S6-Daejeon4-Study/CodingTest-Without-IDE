import java.util.Comparator;
import java.util.PriorityQueue;

public class PRO42627_디스크컨트롤러 {
	class Solution {
	    public int solution(int[][] jobs) {
	        int answer = 0;
	        int time = 0;
	        int N = jobs.length;
	        PriorityQueue<Disk> waitPQ = new PriorityQueue<>(new Comparator<Disk>() {
	            public int compare(Disk d1, Disk d2) {
	                return d1.time - d2.time;
	            }
	        });
	        PriorityQueue<Disk> taskPQ = new PriorityQueue<>(new Comparator<Disk>() {
	            public int compare(Disk d1, Disk d2) {
	                return d1.len - d2.len;
	            }
	        });
	        for(int i = 0 ; i < N ; i++) {
	            waitPQ.offer(new Disk(jobs[i][0], jobs[i][1]));   
	        }
	        while(!waitPQ.isEmpty() || !taskPQ.isEmpty()) {
	            while(!waitPQ.isEmpty() && time >= waitPQ.peek().time) {
	                taskPQ.offer(waitPQ.poll());
	            }
	            if(taskPQ.isEmpty()) {
	                time = waitPQ.peek().time;
	                continue;
	            }
	            Disk now = taskPQ.poll();
	            answer += (time - now.time) + now.len;
	            time += now.len;
	        }
	        
	        return answer / N;
	    }
	    public class Disk {
	        int time, len;
	        public Disk(int time, int len){
	            this.time = time;
	            this.len = len;
	        }
	    }
	}
}
