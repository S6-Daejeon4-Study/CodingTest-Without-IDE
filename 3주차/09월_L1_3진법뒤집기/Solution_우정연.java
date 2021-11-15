
public class PRO68935_3진법뒤집기 {
//	방법 1
	public int solution1(int n) { 
        int answer = 0;
        String s = "";
        
        while(n != 0) {
            s = (n % 3) + s;
            n /= 3;
        }
        
        for(int i = 0 ; i < s.length() ; i++) {
            answer += (s.charAt(i) - '0') * (int)Math.pow(3, i);
        }
        
        return answer;
    }
	
//	방법 2
	public int solution2(int n) {	// 얘가 훨씬 더 빠름
        int answer = 0;
        
        while(n != 0) {				// 3진법 수의 길이가 얼만지 모르니까 저장된 수에 계속 3 곱해주면서 10진수로 만들기
            answer *= 3;
            answer += (n % 3);
            n /= 3;
        }
        
        return answer;
    }
}
