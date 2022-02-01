import java.util.*;
class Solution {
    HashMap<String, Integer> map;
    public String[] solution(String[] orders, int[] course) {
        // String[] answer = {};
        ArrayList<String> answerList = new ArrayList<>();
        map = new HashMap<>();
        for(String order : orders){
            char[] orderArray = order.toCharArray();
            Arrays.sort(orderArray);
            subset(0,"",orderArray);
        }
        HashMap<Integer, Integer> popularCntMap= new HashMap<>();
        for(String key : map.keySet()){
            // System.out.println(key+ " "+map.get(key));
            if(map.get(key)>=2){
                for(int i=0; i< course.length;i++){
                    if(key.length()==course[i]){
                        if(popularCntMap.containsKey(course[i])) popularCntMap.put(course[i],Math.max(map.get(key),popularCntMap.get(course[i])));
                        else popularCntMap.put(course[i],map.get(key));
                    } 
                }
            }
        }
        
        for(String key : map.keySet()){
            System.out.println(key+ " "+map.get(key));
            if(map.get(key)>=2){
                if(popularCntMap.get(key.length())==map.get(key))answerList.add(key);
            }
        }
        String[] answer = answerList.toArray(new String[answerList.size()]);
        Arrays.sort(answer);
        return answer;
    }
    public void subset(int idx, String subset, char[] order){
        if(idx==order.length){
            if(map.containsKey(subset)) map.put(subset,map.get(subset)+1);
            else map.put(subset,1);
            return;
        }
        subset(idx+1,subset+order[idx],order);
        subset(idx+1,subset,order);
    }
}