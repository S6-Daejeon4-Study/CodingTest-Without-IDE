import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        HashMap<String,Integer> map = new HashMap<>();
        HashMap<String,Integer> costMap = new HashMap<>();
        for(String record : records){
            String[] r = record.split(" ");
            int time = convertToInt(r[0]);
            if(r[2].equals("IN")) map.put(r[1],time);
            else {
        
                costMap.put(r[1],costMap.getOrDefault(r[1],0)+time-map.get(r[1]));
                map.put(r[1],-1);
            }
         }
        int todayEnd= 23*60+59;
        for(String key : map.keySet()){
            if(map.get(key)!=-1)
                costMap.put(key,costMap.getOrDefault(key,0)+todayEnd-map.get(key));  
        }
    
        
        List<String> sortedCarList = new ArrayList(map.keySet());
        int N = sortedCarList.size();
        Collections.sort(sortedCarList);
        int[] answer = new int[N];
        for(int i=0; i<N;i++){
            answer[i]=calculate(costMap.get(sortedCarList.get(i)),fees);
        }
        return answer;
    }
    public int convertToInt(String time){
        String[] t = time.split(":");
        return Integer.parseInt(t[0])*60+Integer.parseInt(t[1]);
    }
    public int calculate(int parkingTime,int[] fees){
        if(parkingTime < fees[0]) return fees[1];
        parkingTime-=fees[0];
        return fees[1]+(int)Math.ceil((double)parkingTime/fees[2])*fees[3];       
    }
}