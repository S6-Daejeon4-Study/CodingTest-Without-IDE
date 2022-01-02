
public class PRO42587_프린터 {
	public int solution(int[] priorities, int location) {
        int answer = 0;
        int size = priorities.length;
        int idx = 0;
        while(true) {
            if(priorities[idx] == 0) {
                idx = (idx + 1) % size;
                continue;
            }
            int n = priorities[idx];
            int nowIdx = (idx + 1) % size;
            boolean isPossible = true;
            while(nowIdx != idx) {
                if(n < priorities[nowIdx]) {
                    isPossible = false;
                    break;
                }
                nowIdx = (nowIdx + 1) % size;
            }
            if(isPossible) {
                answer++;
                if(location == idx) break;
                priorities[idx] = 0;
            } 
            idx = (idx + 1) % size;
        }
        return answer;
    }
}
