import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        TreeMap<Integer,Integer> map = new TreeMap<>();
        
        for(int i=0;i<operations.length;i++){
            StringTokenizer st = new StringTokenizer(operations[i]);
            
            String command = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            
            if(command.equals("I")){
                map.put(num,map.getOrDefault(num,0)+1);
            }else{
                if(map.size()!=0){
                    if(num==1) {
                        if(map.get(map.lastKey())==1){
                            map.remove(map.lastKey());   
                        }else{
                            map.put(map.lastKey(),map.get(map.lastKey())-1);
                        }
                    }
                    if(num==-1){
                        if(map.get(map.firstKey())==1){
                            map.remove(map.firstKey());  
                        }else{
                            map.put(map.firstKey(),map.get(map.firstKey())-1);
                        }
                    } 
                }
            }
        }
        
        if(map.size()==0){
            answer[0]=answer[1]=0;
        }else{
            answer[0]=map.lastKey();
            answer[1]=map.firstKey();
        }
        return answer;
    }
}