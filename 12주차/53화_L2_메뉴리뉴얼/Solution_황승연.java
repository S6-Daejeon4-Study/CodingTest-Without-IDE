import java.util.*;

class Solution {
    static int num;
    static char[] arr;
    static String result;
    static Map<String,Integer> map;
    static int max;
    public List<String> solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        
        map = new HashMap<>();
        
        for(int i=0;i<course.length;i++){
            num = course[i];
            max=0;
            map.clear();
            for(int j=0;j<orders.length;j++){
                arr = orders[j].toCharArray();
                if(arr.length<num){
                    continue;
                }
                Arrays.sort(arr);
                result="";
                comb(0,0);
            }
            if(max>=2){
                for(String key:map.keySet()){
                    if(map.get(key)==max){
                        answer.add(key);
                    }
                }   
            }
        }
        
        Collections.sort(answer);
        return answer;
    }
    
    static void comb(int cnt,int start){
        if(cnt==num){
            map.put(result,map.getOrDefault(result,0)+1);
            max = Math.max(max,map.get(result));
            return;
        }
        
        for(int i=start;i<arr.length;i++){
            result+=(arr[i]+"");
            comb(cnt+1,i+1);
            result=result.substring(0,cnt);
        }
    }
}