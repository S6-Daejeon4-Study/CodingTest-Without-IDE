import java.util.*;
class Solution {
    static HashMap<String, Integer> map = new HashMap<>();
    static HashMap<Integer, Integer> cnt = new HashMap<>();
    static PriorityQueue<String> pq = new PriorityQueue<>();
    static char[] order;
    static int len;
    public String[] solution(String[] orders, int[] course) {
        
        for(int i = 0; i < course.length; i++){
            cnt.put(course[i], 0); // 
        }
        
        for(int i = 0; i < orders.length; i++){
            order = orders[i].toCharArray();
            len = order.length;
            subset(0,"");
        }
        
        Iterator<String> keys = map.keySet().iterator();
        
        while(keys.hasNext()){
            String key = keys.next();
            //System.out.println(key + " : " + map.get(key));
            if(map.get(key) > 1 && map.get(key) == cnt.get(key.length()) )
                pq.add(key);
        }
        
        int pqSize = pq.size();
        String[] answer = new String[pqSize];

        for(int i = 0; i < pqSize; i++){
            answer[i] = pq.poll();
        }

        return answer;
    }
    
    static void subset(int idx, String menu){
        if(idx == len){
            PriorityQueue<String> pqTmp = new PriorityQueue<>();
            char[] tmp = menu.toCharArray();
            for(int i = 0; i < tmp.length; i++){
                pqTmp.add(tmp[i] + "");
            }
            menu = "";
            for(int i = 0; i < tmp.length; i++){
                menu += pqTmp.poll();
            }
            
            
            if(cnt.containsKey(menu.length())){
                if(map.containsKey(menu))
                    map.put(menu, map.get(menu) + 1);
                else
                    map.put(menu, 1);
                
                if(cnt.get(menu.length()) < map.get(menu))
                    cnt.put(menu.length(),  map.get(menu));
            }
            return;
        }
        
        subset(idx + 1, menu + order[idx]);
        subset(idx + 1, menu);
    }
}