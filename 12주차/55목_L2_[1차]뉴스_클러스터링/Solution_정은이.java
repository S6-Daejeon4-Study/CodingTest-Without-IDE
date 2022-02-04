import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        str1=str1.toLowerCase();
        str2=str2.toLowerCase();
        int answer = 0;
        HashMap<String,Integer> subset1 = makeSubset(str1);
        HashMap<String,Integer> subset2 = makeSubset(str2);
        if(subset1.size()==0&&subset2.size()==0) return 65536;
        HashMap<String,Integer> union = new HashMap<>();
        HashMap<String,Integer> inter = new HashMap<>();
    
        for(String s : subset1.keySet()){
            if(union.containsKey(s)) {
                union.put(s,Math.max(subset1.get(s),union.get(s)));
            }
            else {
                union.put(s,subset1.get(s));
                inter.put(s,0);
            }
        }
        for(String s : subset2.keySet()){
            if(union.containsKey(s)) union.put(s,Math.max(subset2.get(s),union.get(s)));
            else union.put(s,subset2.get(s));
            if(inter.containsKey(s)) inter.put(s,1);
        }
        int unionCnt=0,interCnt=0;                                       
        for(String s : union.keySet()){
            unionCnt+=union.get(s);
            if(inter.containsKey(s) && inter.get(s)==1) interCnt += Math.min(subset1.get(s),subset2.get(s));
        }
        answer =(int) Math.floor(((double) interCnt/unionCnt)*65536);                      
        return answer;
    }
    public HashMap<String,Integer> makeSubset(String str){
        HashMap<String,Integer> subset = new HashMap<>();
        for(int i=0; i<str.length()-1;i++){
            char a = str.charAt(i); 
            char b = str.charAt(i+1); 
            if(!isAlphabet(b)){
                i++;
                continue;
            }
            String s = a+""+b;
            if(isAlphabet(a)){
                if(subset.containsKey(s)) subset.put(s,subset.get(s)+1);
                else subset.put(s,1);
            }
        }
        return subset;
    }
    public boolean isAlphabet(char char1){
        return (char1 >= 'a' && char1 <= 'z');
    }
}