import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        LinkedList<String> cache = new LinkedList<String>();
        
        int answer = 0;
        for(String city : cities){
            String save = city.toLowerCase();
            
            if(cache.contains(save)){
                cache.remove(cache.indexOf(save));
                answer+=1;
            }else{
                if(cache.size() >= cacheSize)
                    cache.poll();
                answer+=5;
            }
            if(cacheSize > 0)
                cache.offer(save);
            // System.out.println(save+","+answer);
        }
        return answer;
    }
}