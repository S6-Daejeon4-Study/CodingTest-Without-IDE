import java.util.PriorityQueue;
import java.util.Comparator;
class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        for(String operation : operations){
            String[] token = operation.split(" ");
            
            if(token[0].equals("I")){
                int input = Integer.parseInt(token[1]);
                maxPQ.add(input);
                minPQ.add(input);
            } else{
                if(maxPQ.size() == 0)
                    continue;
                if(token[1].equals("1")){
                    int maxNum = maxPQ.peek();
                    maxPQ.remove(maxNum);
                    minPQ.remove(maxNum);
                } else{
                    int minNum = minPQ.peek();
                    maxPQ.remove(minNum);
                    minPQ.remove(minNum);
                }
                    
            }
        }
        int[] ans = new int[2];
        
        if(maxPQ.size() == 0)
            return ans;
        else{
            ans[0] = maxPQ.peek();
            ans[1] = minPQ.peek();
            return ans; 
        }   
    }
}