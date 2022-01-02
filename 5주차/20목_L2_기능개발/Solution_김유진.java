import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int len = progresses.length;
        Queue<Integer> q = new LinkedList<Integer>();
        int cnt = 0;
        int idx = 0;
        while(len != cnt){
            for(int i = 0;i<len;i++){
                if(progresses[i] < 100)
                    progresses[i] += speeds[i];
            }
            
            int todayCnt = 0;
            while(idx < len && progresses[idx] >= 100){
                idx++;
                todayCnt++;
                cnt++;
            }
            
            if(todayCnt > 0 )
                q.add(todayCnt);
        }
        

        int[] ans = new int[q.size()];
        int i = 0;
        while(!q.isEmpty()){
            ans[i++] = q.poll();
        }
        return ans;
    }
}