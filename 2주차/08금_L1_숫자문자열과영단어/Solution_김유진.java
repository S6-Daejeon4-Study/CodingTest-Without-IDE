import java.util.*;
import java.lang.*;
class Solution {
    static String[] num= {"zero","one","two","three","four","five","six","seven","eight","nine"};
    public int solution(String s) {
        int answer = 0;
        
        for(int i = 0;i<s.length();i++){
            char charNow = s.charAt(i);
            
            if(charNow>='0' && charNow<='9'){
                System.out.println(charNow-'0');
                answer = (answer * 10) + (charNow - '0') ;
            }else{
                for(int j = 0; j<10;j++){
                    int len = num[j].length();
                    if(len + i > s.length())
                        continue;
                    if(s.substring(i,i+len).equals(num[j])){
                        answer = (answer * 10) + j ;
                        break;
                    }
                }
            }
        }
        
        return answer;
    }
}