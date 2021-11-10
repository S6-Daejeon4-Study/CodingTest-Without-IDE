class Solution {
    int size = 0;
    boolean[] used = null;
    int[] arr = null;
    int answer = 0;
    
    public int solution(int[] nums) {
        for(int i = 0 ; i < nums.length ; i ++){
            for(int j = i + 1 ; j < nums.length ; j ++){
                for( int k = j +1 ; k < nums.length ; k ++){
                    int sum = nums[i] + nums[j] + nums[k];
                    if(isPrime(sum))
                        answer++;
                }
            }
        }
        
//         used = new boolean[nums.length];
//         arr = nums;
        
//         comb(0,0);
        
        return answer;
    }
    
    public void comb(int idx, int cnt){
        if(idx == arr.length){
            return;
        }
        
        if(cnt == 3){
            int sum = 0;     
            for(int i = 0 ; i < arr.length ; i ++){
                if(used[i]) sum = sum + arr[i];
            }
            
            if(isPrime(sum)){
                answer ++;
            }    
            return;
        }
        
        used[idx] = true;
        comb(idx + 1, cnt + 1);
        used[idx] = false;
        comb(idx + 1, cnt);
    }
    
    public boolean isPrime(int val){ // 소수 판단 : 1과 자기자신으로 나누어 떨어지지 않는다.
        for(int i = 2 ; i < val ; i ++){
            if(val % i == 0) return false;
        }
        return true;
    }
}