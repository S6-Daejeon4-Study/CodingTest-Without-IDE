import java.util.*;

class Solution {
    static int col;
    static boolean[] isSelected;
    static Map<String,Integer> answerMap;
    static Map<String,Integer> map;
    static int row;
    static StringBuilder sb;
    static String[][] Relation;
    public int solution(String[][] relation) {
        int answer = 0;
        
        col = relation[0].length;
        row = relation.length;
        answerMap = new HashMap<>();
        map = new HashMap<>();
        Relation = relation;
        
        isSelected = new boolean[col];
        subset(0);
        
     
        answer = answerMap.size();
        return answer;
    }
    
    static void subset(int cnt){
        if(cnt==col){
            String str = "";
            for(int i=0;i<col;i++){
                if(isSelected[i]){
                    str+=(i+"")+" ";
                }
            }
            if(str.equals("")){
                return;
            }
            
            //내 컬럼집합중에 후보키가 되는애가 포함되어 있다면 나는 패스
            String[] arr = str.split(" ");
            for(String key: answerMap.keySet()){
                String[] arr2 = key.split(" ");
                int len = arr2.length;
                int count=0;
                for(int i=0;i<len;i++){
                    for(int j=0;j<arr.length;j++){
                        if(arr2[i].equals(arr[j])){
                            count++;
                            break;
                        }
                    }
                }
                
                if(count==len){
                    return;
                }
            }
            
            // for(String key: answerMap.keySet()){
            //     if(str.contains(key)){
            //         return;
            //     }
            // }
            
            //되는지 검사
            map.clear();
            for(int i=0;i<row;i++){
                sb = new StringBuilder();
                for(int j=0;j<col;j++){
                    if(isSelected[j]){
                        sb.append(Relation[i][j]+" ");
                    }
                }
                map.put(sb+"",0);
            }
            
            if(map.size()==row){
                answerMap.put(str,0);
            }
            
            return;
        }
        
        isSelected[cnt]=false;
        subset(cnt+1);
        isSelected[cnt]=true;
        subset(cnt+1);
    }
}