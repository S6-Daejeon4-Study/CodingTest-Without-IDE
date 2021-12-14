
import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        Stack<Person> stack = new Stack<>();
        HashMap<String, String> map = new HashMap<>();
        
        for(int i = 0 ; i < record.length ; i++){
            String[] token = record[i].split(" ");
            
            if(token[0].equals("Enter")){
                map.put(token[1], token[2]);
                stack.push(new Person(token[1], 0));
            } else if(token[0].equals("Change")){
                map.put(token[1], token[2]);
            }
            else{
                stack.push(new Person(token[1], 1));
            }
        }
        
        String[] answer = new String[stack.size()];
        for(int i = stack.size()-1 ; i >= 0 ; i--){
            Person now = stack.pop();
            String nickName = map.get(now.userId);
            String content = "";
            if(now.status == 0){
                content = "님이 들어왔습니다.";
            }else{
                content = "님이 나갔습니다.";
            }
            answer[i] = nickName + content;
        }
        
        return answer;
    }
    
    class Person {
        String userId;
        int status;
        
        public Person(String userId, int status){
            this.userId = userId;
            this.status = status;
        }
    }
}