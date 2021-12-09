import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        int[] days = new int[progresses.length];
        
        for(int i=0; i<progresses.length;i++){
            int todo=100-progresses[i];
            days[i]=todo/speeds[i];
            if(todo%speeds[i]!=0)days[i]++;
        }
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        
        int cnt =1;
        stack.push(days[0]);
        
        for(int i=1; i<days.length;i++){     
            int previous = (int)stack.peek();
            if(days[i]<=previous){
                cnt++;
            }else{
                stack.push(days[i]);
                result.add(cnt);
                cnt=1;
            }
        }
        result.add(cnt);
        
        int[] answer = new int[result.size()];
        for(int i=0; i<result.size();i++){
            answer[i]=(int)result.get(i);
        }
        return answer;
    }
}