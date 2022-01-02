import java.util.ArrayList;

public class PRO42586_기능개발 {
	public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();
        int cnt = 1;
        int max = (100 - progresses[0] + speeds[0] - 1) / speeds[0];
        for(int i = 1 ; i < progresses.length ; i++) {
            int endTime = (100 - progresses[i] + speeds[i] - 1) / speeds[i];
            if(endTime <= max) {
                cnt++;
            } else {
                list.add(cnt);    
                max = endTime;
                cnt = 1;
            }
        }
        // ArrayList to Array
        if(cnt > 0) list.add(cnt);
        int[] answer = new int[list.size()];
        for(int i = 0 ; i < list.size() ; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
