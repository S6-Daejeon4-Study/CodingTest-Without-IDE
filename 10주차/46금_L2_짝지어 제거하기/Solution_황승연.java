import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = 0;

        int size = s.length();
        Stack<Character> stack = new Stack<>();
        
        for(int i=0;i<size;i++){
            if(stack.isEmpty() || stack.peek() != s.charAt(i)){
                stack.push(s.charAt(i));
                continue;
            }
            stack.pop();
        }
        
        if(stack.isEmpty()){
            answer=1;
        }

        return answer;
    }
}