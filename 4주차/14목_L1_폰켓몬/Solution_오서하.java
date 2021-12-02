import java.util.HashSet;

class Solution {
    int N = 0;
    int answer = -1;
    int[] arr ;
    HashSet<Integer> set;
    boolean visit[];
 
    public int solution(int[] nums) {
        N = nums.length;
        set = new HashSet<Integer>();
        
        for(int i = 0 ; i < N ; i++){
            set.add(nums[i]);    
        }
        
        if((N/2) <= set.size())
            return N/2;
        else{
            return set.size();
        }
    }
}