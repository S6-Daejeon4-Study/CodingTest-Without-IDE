import java.util.*;

class Solution {
    public String[] solution(String[] record) {

        Map<String,String> map = new HashMap<>();
        int num=0;
        
        for(int i=0;i<record.length;i++){
            StringTokenizer st = new StringTokenizer(record[i]);
            
            String command = st.nextToken();
            String id = st.nextToken();
            String nickName = "";
            
            if(!command.equals("Leave")){
                nickName = st.nextToken(); 
            }
            
            if(!map.containsKey(id)){
                map.put(id,nickName);
            }else if(command.equals("Enter")){
                map.replace(id,nickName);
            }
            
            if(command.equals("Change")){
                map.replace(id,nickName);
            }else{
                num++;
            }
        }
        
        String[] ans = new String[num];
        int index=0;
        
        for(int i=0;i<record.length;i++){
            StringTokenizer st = new StringTokenizer(record[i]);
            
            String command = st.nextToken();
            String id = st.nextToken();
            String nickName = "";
            if(!command.equals("Leave")){
                nickName = st.nextToken(); 
            }
            
            if(command.equals("Enter")){
                ans[index] = map.get(id)+"님이 들어왔습니다.";
                index++;
            }else if(command.equals("Leave")){
                ans[index] = map.get(id)+"님이 나갔습니다.";
                index++;
            }
        }
        return ans;
    }
}