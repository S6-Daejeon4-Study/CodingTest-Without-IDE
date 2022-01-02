import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        HashMap<String,String> userMap = new HashMap<>();
        String[] recordLine;
        for(String s : record){
            recordLine = s.split(" ");
            if(recordLine[0].equals("Change")||recordLine[0].equals("Enter"))
                userMap.put(recordLine[1],recordLine[2]);           
        }
        ArrayList<String> answerList = new ArrayList<>();
        for(String s : record){
             recordLine = s.split(" ");
           if(recordLine[0].equals("Enter")){
               answerList.add(userMap.get(recordLine[1])+"님이 들어왔습니다.");
            }
            if(recordLine[0].equals("Leave")){
                answerList.add(userMap.get(recordLine[1])+"님이 나갔습니다.");
            }
        }
        String[] answer = answerList.toArray(new String[answerList.size()]);
        return answer;
    }
}