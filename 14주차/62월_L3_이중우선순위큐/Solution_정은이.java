import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        for(String operation : operations){
            String[] os = operation.split(" ");
            int num = Integer.parseInt(os[1]);
            if(os[0].equals("I")){
                minPq.add(num);
                maxPq.add(num);
            }
            
            else if(!minPq.isEmpty()){
                if(num==-1){
                    Integer min = minPq.poll();
                    maxPq.remove(min);
                    while(maxPq.size()<minPq.size()){
                        maxPq.add(min);
                    }
                }
                else if(num==1){
                    Integer max = maxPq.poll();
                    minPq.remove(max);
                    while(maxPq.size()>minPq.size()){
                        minPq.add(max);
                    }
                }
            }
        }
        
        if(minPq.isEmpty()) return new int[]{0,0}  ;
        else return new int[]{maxPq.poll(),minPq.poll()};
        
    }
}