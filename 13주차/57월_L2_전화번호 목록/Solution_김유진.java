import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        
        int len = phone_book.length;
        HashSet<String> set = new HashSet<>();
        
        for(int i = 0; i < len; i++){
            set.add(phone_book[i]);
        }
        
        for(int i = 0; i < len; i++){
            int slen = phone_book[i].length();
            for(int j = 1; j < slen; j++){
                String tmp = phone_book[i].substring(0,j);
                if(set.contains(tmp))
                    return false;
            }
            
        }
        
        
        
        return true;
        
    }
}