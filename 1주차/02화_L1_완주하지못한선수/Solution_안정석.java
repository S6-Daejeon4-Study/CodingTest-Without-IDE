// 시간초과 답변
import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        boolean arr[] = new boolean[participant.length];
        for(int i=0; i<participant.length; i++){
            for(int j=0; j<completion.length; j++){
                if(participant[i].equals(completion[j])){
                    participant[i] = "-1";
                    completion[j] = "-1";
                }
            }
            if(!participant[i].equals("-1")){
                answer = participant[i];
                break;
            }
        }
    
        return answer;
    }
}
// 정답 답변
import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        for(int i=0; i<completion.length; i++){
            if(participant[i].equals(completion[i])){
                participant[i] = "-1";
                completion[i] = "-1";
            } else {
                answer = participant[i];
                break;
            }
        }
        if(answer.equals("")){
            answer = participant[participant.length-1];
        }
        return answer;
    }
}