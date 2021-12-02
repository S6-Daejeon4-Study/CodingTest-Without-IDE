class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        int size = nums.length;
        int[] kind = new int[200001];
        for(int i=0;i<size;i++){
            kind[nums[i]]++;
        }
        
        for(int i=1;i<200001;i++){
            if(kind[i] !=0){
                answer++;
            }
            if(answer==size/2){
                break;
            }
        }
        
        return answer;
    }
}