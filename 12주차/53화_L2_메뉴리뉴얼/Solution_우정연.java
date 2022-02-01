import java.util.*;

public class PRO72411_메뉴리뉴얼 {
    Map<String, Integer> map;
    ArrayList<String> result;
    int max;
    public String[] solution(String[] orders, int[] course) {
        result = new ArrayList<>();
        for(int i = 0 ; i < course.length ; i++) {
            max = -1;
            map = new HashMap<>();
            for(int j = 0 ; j < orders.length ; j++) {
                subset(0, "", orders[j], course[i]);
            }
            if(max >= 2) {
                for(String key : map.keySet()) {
                    if(map.get(key) == max) {
                        result.add(key);
                    }
                } 
            }
        }
        Collections.sort(result);
        String[] answer = new String[result.size()];
        int idx = 0;
        for(String s : result) {
            answer[idx++] = s;
        }
        return answer;
    }
    void subset(int idx, String s, String order, int len) {
        if(s.length() == len) {
            char[] cArr = s.toCharArray();
            Arrays.sort(cArr);
            s = new String(cArr);
            if(map.get(s) == null) map.put(s, 1);
            else map.put(s, map.get(s) + 1);
            max = Math.max(max, map.get(s));
            return;
        }
        if(idx == order.length()) return;
        subset(idx + 1, s + order.charAt(idx), order, len);
        subset(idx + 1, s, order, len);
    }
}
