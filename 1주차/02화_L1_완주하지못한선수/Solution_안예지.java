package day1109;
import java.util.*;

class Programmers_완주하지못한선수 {
	public static void main(String[] args) {
	Programmers_완주하지못한선수 p = new Programmers_완주하지못한선수(); // static이 붙어있지 않기 때문에 생성자로 프로그래머스 객체를 만들어준다

	String[] participant = {"leo", "kiki", "eden"};
	String[] completion = {"eden", "kiki"};
	
	
	
	
	String result= p.solution(participant, completion);
	System.out.println(result);
	}
	
    public String solution(String[] participant, String[] completion) {
        String answer = "";

    Arrays.sort(participant);
    Arrays.sort(completion);
        answer=participant[participant.length-1];
        
    for(int i=0; i<completion.length;i++){
       if(!completion[i].equals(participant[i])){
           answer=participant[i];
        break;
       }
    }
        
         
        
    return answer;
    
    }
}