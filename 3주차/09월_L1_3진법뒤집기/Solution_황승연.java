import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
       
        int num=0;      //자릿수
        
        while(true){
            if(n<(int)Math.pow(3,num)){
                break;
            }
            num++;
        }
        
        int number = (int)Math.pow(3,num-1);
        
        StringBuilder sb = new StringBuilder();
       
        while(num-->0){
            if(n==0){
                sb.append(0);
            }else{
                int rest = n/number;
                sb.append(rest);
                n = n%number;
             number = number/3;    
            } 
        }
        
        sb.reverse();
        for(int i=sb.length()-1;i>=0;i--){
            answer += (sb.charAt(sb.length()-1-i)-'0') * Math.pow(3,i);
        }
        
        
        return answer;
    }
}