import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        ArrayList<String> list = new ArrayList<>();
        if(cacheSize<1) return cities.length*5;
        for(String city : cities){
            city = city.toUpperCase();
            if(!list.contains(city)) {
                answer+=5;
                if(list.size()<cacheSize){
                    list.add(city);
                }
                else if(list.size()==cacheSize){
                    list.remove(0);
                    list.add(city);
                }
                
            }
            else {
                answer++;
                list.remove(city);
                list.add(city);
            }
                
        }
        
        return answer;
    }
}