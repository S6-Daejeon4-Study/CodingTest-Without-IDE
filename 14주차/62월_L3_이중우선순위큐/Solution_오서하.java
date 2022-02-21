import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0 ; i < operations.length ; i++){
            String[] str = operations[i].split(" ");
            int num = Integer.parseInt(str[1]);
            
            if(str[0].equals("D")){
                if(pq.size() == 0) continue;
                else if(pq.size() == 1) pq.poll();
                else{
                    if(num == 1){
                        int s = pq.size();
                        PriorityQueue<Integer> pq1 = new PriorityQueue<>( Collections.reverseOrder());
                        for(int j = 0 ; j < s -1; j ++){
                            int n = pq.poll();
                            pq1.add(n);
                        }
                        pq.poll();
                        
                        while(!pq1.isEmpty()){
                            int addn = pq1.poll();
                            pq.add(addn);
                        }   
                    }else{
                        pq.poll();
                    }
                }
            }else{
                pq.add(num);
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>(); 
        while(!pq.isEmpty()){
            list.add(pq.poll());
        }
        
        
        int[] answer = new int[2];
        
        if(list.size() > 1){
            Collections.sort(list);
            int lastIdx = list.size()-1;
            answer[0] = list.get(lastIdx);
            answer[1] = list.get(0);
        } else if(list.size() == 1){
            answer[0] = list.get(0);
            answer[1] = 0;
        }
        
        else{
            answer[0] = 0;
            answer[1] = 0;
        }
        return answer;
    }
}