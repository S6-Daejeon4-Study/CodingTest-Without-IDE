

public class PRO62048_멀쩡한사각형 {
	class Solution {
	    public long solution(int w, int h) {
	        long answer = 1;
	        int gcdNum = gcd(w, h);
	        int a = w / gcdNum;
	        int b = h / gcdNum;
	        int cnt = -1;
	        int j = 0, lastJ = 0;
	        for(int i = 1 ; i <= b ; i++) { // 1) 한칸씩 더하는거 했다가 정확한 계산이 안되서 곱하기로 매번 계산하는걸로 바꿈
	            j = (int)(((double)a * i) / (double)b);     // 2) 여기 곱하기 먼저했다가 int범위 나가버림
	            cnt += j - lastJ + 1;
	            lastJ = j;
	        }
	        answer = (long)w * h - (long)cnt * gcdNum;
	        
	        return answer;
	    }
	    int gcd(int a, int b) {
	        int tmp = 0;
	        while(b != 0) {
	            tmp = a % b;
	            a = b;
	            b = tmp;
	        }
	        return a;
	    }
	}
}
