import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        if(s.length()%2==0){
            Stack<Character> stack = new Stack<>();
            int idx =0;
            stack.add(s.charAt(idx++));
            
            while(true){
                if(idx>=s.length()) break;
                if(stack.isEmpty() || stack.peek()!=s.charAt(idx)){
                   stack.push(s.charAt(idx));
                }
                else{
                    stack.pop();
                }
                idx++;
            }
            if(stack.isEmpty()) answer =1;
        }
        return answer;
    }
}