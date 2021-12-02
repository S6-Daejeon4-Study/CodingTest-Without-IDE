import java.util.HashSet;
import java.util.Set;
public class PRO1845_폰켓몬 {
	class Solution {
	    public int solution(int[] nums) {
	        int answer = nums.length / 2;
	        Set<Integer> set = new HashSet<>();
	        for(int i = 0 ; i < nums.length ; i++) {
	            set.add(nums[i]);
	        }
	        if(set.size() < answer) answer = set.size();
	        
	        return answer;
	    }
	}
}
