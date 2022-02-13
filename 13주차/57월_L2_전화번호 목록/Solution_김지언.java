import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Map<String, Boolean> map = new HashMap<>();
        
        for(String phone : phone_book) 
            map.put(phone, true);
        
        for(String phone: phone_book) {
            for(int i = 1; i < phone.length(); i++) {
                if(map.containsKey(phone.substring(0, i))) 
                    return false;
            }
        }
        return true;
    }
}