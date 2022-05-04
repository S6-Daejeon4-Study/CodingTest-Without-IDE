import java.util.*;
class Solution {
    public String solution(String p) {
        return make(p);
    }
    public String make(String w){
        if(w.length()==0) return "";
        StringBuilder u = new StringBuilder();        
        String v;
        int front = 0;
        int back = 0 ;
        int idx=0;
        
        for(int i=0;i<w.length();i++){
            idx++;
            if(w.charAt(i)=='(') front++;
            if(w.charAt(i)==')') back++;
            u.append(w.charAt(i));
             if(front==back) break;
        }
        v= w.substring(idx,w.length());
        
        if(isAlrightString(u.toString())) return u+make(v);
        else {
            u.deleteCharAt(0);
            u.deleteCharAt(u.length()-1);
            for(int i=0;i<u.length();i++){
                if(u.charAt(i)=='(')  u.replace(i,i+1,")");
                else u.replace(i,i+1,"(");
            }
            return "("+make(v)+")"+u.toString();        
        }
        
    }
    public boolean isAlrightString(String s){
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==')') {
                if(stack.isEmpty()) return false;
                if( stack.peek()=='(') stack.pop();
            }
            if(s.charAt(i)=='(') stack.push('(');
        }
        return stack.isEmpty();
    }
}