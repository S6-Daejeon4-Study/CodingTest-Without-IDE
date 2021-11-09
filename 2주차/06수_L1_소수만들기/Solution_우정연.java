
public class PRO12977_소수만들기 {
	class Solution {
	    final int DEPTH = 3;
	    int sum, answer;
	    public int solution(int[] nums) {
	        answer = 0;
	        comb(0, 0, nums);
	        return answer;
	    }
	    void comb(int idx, int cnt, int[] nums) {
	        if(cnt == DEPTH) {
	            if(isDecimal(sum)) {
	                answer++;
	            }
	            return;
	        }
	        if(idx == nums.length) {
	            return;
	        }
	        sum += nums[idx];
	        comb(idx + 1, cnt + 1, nums);
	        sum -= nums[idx];
	        comb(idx + 1, cnt, nums);
	    }
	    boolean isDecimal(int n) {
	        for(int i = 2 ; i < n ; i++) {
	            if(n % i == 0) return false;
	        }
	        return true;
	    } 
	}
}
