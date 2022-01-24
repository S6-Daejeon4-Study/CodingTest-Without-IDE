
import java.util.*;

public class PRO12973_짝지어제거하기 {
	class Solution
	{
	    public int solution(String s)
	    {
	        int answer = 0;
	        Stack<Character> stack = new Stack<>();
	        int idx = 0;
	        boolean isEnd = false;
	        while(idx < s.length()) {
	            char c = s.charAt(idx++);
	            while(true) {
	                if(stack.isEmpty() || stack.peek() != c) break;
	                stack.pop();
	                if(idx == s.length()) {
	                    isEnd = true;
	                    break;
	                }
	                c = s.charAt(idx++);
	            }    
	            if(isEnd) break; 
	            stack.add(c);
	        }
	        
	        if(stack.isEmpty()) answer = 1;
	        return answer;
	    }
	}
}
