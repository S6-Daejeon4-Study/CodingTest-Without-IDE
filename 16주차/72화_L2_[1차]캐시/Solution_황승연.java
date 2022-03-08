import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        LinkedList<String> list = new LinkedList<>();
        
        for(int i=0;i<cities.length;i++){
            String str = cities[i];
            str = str.toLowerCase();
            
            if(list.contains(str)){
                answer+=1;
                int index = list.indexOf(str);
                list.remove(index);
            }else{
                answer+=5;
            }
            list.addFirst(str);
            if(list.size()>cacheSize){
                list.removeLast();
            }
            
        }
        return answer;
    }
}