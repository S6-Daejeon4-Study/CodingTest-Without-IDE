import java.util.Map;
import java.util.HashMap;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        for(String s : participant) {
            if(map.get(s) == null) {
                map.put(s, 1);
            } else {
                map.put(s, map.get(s) + 1);
            }
        }
        for(String s : completion) {
            if(map.get(s) > 1) {
                map.put(s, map.get(s) - 1);
            } else {
                map.remove(s);
            }
        }
        for(String s : map.keySet()) {
            answer = s;
        }
        return answer;
    }
}