import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        Map<String,Integer> map1 = new HashMap<>();
        Map<String,Integer> map2 = new HashMap<>();

        for(int i=1;i<str1.length();i++){
            if(!check(str1.charAt(i-1)) || !check(str1.charAt(i))){
                continue;       //문자아닌거 거르기
            }
            
            String str="";
            if(str1.charAt(i-1)-'a'>=0 && str1.charAt(i-1)-'z'<=0){
                str+=(char)(str1.charAt(i-1)-32);
            }else{
                str+=str1.charAt(i-1);
            }
            
            if(str1.charAt(i)-'a'>=0 && str1.charAt(i)-'z'<=0){
                str+=(char)(str1.charAt(i)-32);
            }else{
                str+=str1.charAt(i);
            }
            map1.put(str,map1.getOrDefault(str,0)+1);
        }
        
        for(int i=1;i<str2.length();i++){
            if(!check(str2.charAt(i-1)) || !check(str2.charAt(i))){
                continue;
            }
            
            String str="";
            if(str2.charAt(i-1)-'a'>=0 && str2.charAt(i-1)-'z'<=0){
                str+=(char)(str2.charAt(i-1)-32);
            }else{
                str+=str2.charAt(i-1);
            }
            
            if(str2.charAt(i)-'a'>=0 && str2.charAt(i)-'z'<=0){
                str+=(char)(str2.charAt(i)-32);
            }else{
                str+=str2.charAt(i);
            }
            map2.put(str,map2.getOrDefault(str,0)+1);
        }

        int common = 0;
        int sum=0;
        
        for(String key:map1.keySet()){
            if(map2.containsKey(key)){
                common+=Math.min(map1.get(key),map2.get(key));
                sum+=Math.max(map1.get(key),map2.get(key));
            }else{
                sum+=map1.get(key);
            }
            
        }
        
        for(String key:map2.keySet()){
            if(!map1.containsKey(key)){
                sum+=map2.get(key);
            }
        }
        
        if(sum==0){
            return 65536;
        }
        
        answer = common*65536/sum;
        return answer;
    }
    
    static boolean check(int num){
        if(num>=65 && num<=90){
            return true;
        }else if(num>=97 && num<=122){
            return true;
        }
        return false;
    }
}