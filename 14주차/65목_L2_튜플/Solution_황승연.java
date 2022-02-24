import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer;
        
        s = s.substring(1,s.length()-1);
        
        String[] arr = s.split("}");
        answer = new int[arr.length];
        
        Arrays.sort(arr, new Comparator<String>(){
            public int compare(String o1, String o2){
                return o1.length()-o2.length();
            }
        });
        
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<arr.length;i++){
            String str = arr[i];
            str=str.replace("{","");
 
            String[] arr2 = str.split(",");
           
            for(int j=0;j<arr2.length;j++){
                String str2 = arr2[j];
                if(str2.equals("")){
                    continue;
                }
                
                int num = Integer.parseInt(str2);
                if(!map.containsKey(num)){
                    map.put(num,1);
                    answer[i]=num;
                    break;
                }
                
            }
        }
       
        return answer;
    }
}