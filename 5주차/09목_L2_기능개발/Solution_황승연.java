import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int size = speeds.length;
        int day=0;
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<size;i++){
            queue.offer(i);
        }
        //준비 끝
        
        while(!queue.isEmpty()){
            int count=0;
            
            while(!queue.isEmpty()){
                int index = queue.peek();
                int temp = progresses[index]+(speeds[index]*day);
                
                if(temp>=100){
                    count++;
                    queue.poll();
                    continue;
                }else{
                    int nam = (100-temp)%speeds[index];
                    day += (100-temp)/speeds[index];

                    if(nam!=0){
                        day+=1;
                    }
                    break;
                }
            }

            if(count!=0){
                answer.add(count);   
            }      
        }
        return answer;
    }
}