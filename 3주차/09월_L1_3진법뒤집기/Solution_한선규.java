import java.util.ArrayList;

class Solution {
    public int solution(int n) {
        int answer = 0;
        ArrayList<Integer> remains = new ArrayList<Integer>();
        
        while(n != 0) {
            remains.add(n % 3);
            n /= 3;
        }
        
        int exp = 0;
        
        for(int i = remains.size() - 1; i >= 0; i--) {
            answer += (remains.get(i) * Math.pow(3, exp++));
        }
        
        return answer;
    }
}