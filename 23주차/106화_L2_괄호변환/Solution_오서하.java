import java.util.*;

class Solution {
    public String solution(String p) {
        String answer = recur(p);
        return answer;
        
    }
    
    public String recur(String p){
        // System.out.println(p);
        //1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다. +원문 자체가 올바른 괄호 문자열이면 그대로 반환  
        if(p == "" || isCollect(p))
            return p;
        //2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
        String u = isBalance(p);
        String v = p.substring(u.length());
        //3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다. 
        if(isCollect(u)){
            
            String temp1 = recur(v);
            //   3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다. 
            return u + temp1;
        }
        //4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
        else{
            String temp = "";
            //4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다. 
            temp += "(";
            //4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
            temp += recur(v);
            //4-3. ')'를 다시 붙입니다. 
            temp += ")";
            // 4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다. 
            if(u.length() > 2){
                for(int i = 1 ; i < u.length() - 1 ; i++){
                    if(u.charAt(i) == '(')
                        temp += ")";
                    else
                        temp += "(";
                }
            }
           // 4-5. 생성된 문자열을 반환합니다.
            return temp;
        }
    }
    
    public boolean isCollect(String p){
        Stack<String>stack = new Stack<String>();
        
        for(int i = 0 ; i < p.length() ; i++){
            if(stack.size() == 0){
                if(p.charAt(i) == ')') 
                    return false;
                else 
                    stack.push("(");
            }else{
                if(p.charAt(i) == ')') stack.pop();
                else stack.push("(");
            }
        }
        
        if(stack.size() == 0) return true;
        else return false;
    }
    
    public String isBalance(String w){
        Stack<String>stack = new Stack<String>();
        
        int right = 0; // )
        int left = 0; // (
        
        String u = "";
        
        for(int i = 0 ; i < w.length() ; i++){
            if(w.charAt(i) == '(')
                left += 1;
            else right += 1;
            
            u += w.charAt(i)+"";
            if(left == right) break;
        }
        return u;
    }
}
