import java.util.*;
class Solution {
    static PriorityQueue<Work> in = new PriorityQueue<>(new Comparator<Work>(){
        @Override
        public int compare(Work o1, Work o2){
            return Integer.compare(o1.s, o2.s);
        }
    });
    static PriorityQueue<Work> work = new PriorityQueue<>(new Comparator<Work>(){
        @Override
        public int compare(Work o1, Work o2){
            return Integer.compare(o1.t, o2.t);
        }
    });
    
    public int solution(int[][] jobs) {
        int len = jobs.length;
        for(int i = 0; i < len; i++){
            in.add(new Work(jobs[i][0], jobs[i][1]));
        }
        int end = 0;
        int ans = 0;
        while(!in.isEmpty()){
            if(!in.isEmpty() && in.peek().s > end){
                end = in.peek().s;
            }
            while(!in.isEmpty() && in.peek().s <= end){
                work.add(in.poll());
                // System.out.println("out" + ans);
            }  
            while(!work.isEmpty()){
                Work tmp = work.poll();
                int start = end < tmp.s ? tmp.s : end;
                end = start + tmp.t;
                ans += end - tmp.s;
                // System.out.println("work" + ans);
            }
            // System.out.println("in" + ans);
        }
        return ans/len;
    }
    static class Work{
        int s, t;
        public Work (int s, int t){
            this.s = s;
            this.t = t;
        }
        
    }
}