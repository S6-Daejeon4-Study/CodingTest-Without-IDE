import java.util.*;
import java.util.regex.Pattern;
class Solution {
    static HashMap<String, Integer> s1, s2;
    public int solution(String str1, String str2) {
        char[] c1 = str1.toUpperCase().toCharArray();
        char[] c2 = str2.toUpperCase().toCharArray();
        
        s1 = new HashMap<>();
        s2 = new HashMap<>();
        
        int len1 = c1.length;
        int len2 = c2.length;
        int idx = 1;
        
        while(idx < len1 || idx < len2){
            if(idx < len1 && Pattern.matches("^[A-Z]*$", "" + c1[idx-1] + c1[idx]))
                add(s1,"" + c1[idx-1] + c1[idx]);
            if(idx < len2 && Pattern.matches("^[A-Z]*$", "" + c2[idx-1] + c2[idx]))
                add(s2,"" + c2[idx-1] + c2[idx]);
            idx++;
        }
        
        int inter = 0;
        int uni = 0;
        
        for(String key : s1.keySet()){
            if(s2.containsKey(key)){
                inter += Math.min(s1.get(key), s2.get(key));
            }else{
                uni += s1.get(key);
            }
        }
        
        
        for(String key : s2.keySet()){
            if(s1.containsKey(key)){
                uni += Math.max(s1.get(key), s2.get(key));
            }else{
                uni += s2.get(key);
            }
        }
       
        if(inter == 0 && uni == 0)
            return 65536;
        else{
            return (int)((float)65536 * (float) inter / (float) uni);
        }
    }
    
    static void add(HashMap<String, Integer> map, String tmp){
        if(map.containsKey(tmp)){
            map.put(tmp, map.get(tmp) + 1);
        }else{
            map.put(tmp, 1);
        }
    }
    
}