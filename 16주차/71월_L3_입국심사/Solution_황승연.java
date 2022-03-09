class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        
        long start =0;
        long end= Long.MAX_VALUE;
        
        while(start<=end){
            long mid = (start+end)/2;
            
            long sum=0;
            for(int i=0;i<times.length;i++){
                sum+=mid/times[i];
                if(sum>=n){
                    break;
                }
            }
            
            if(sum>=n){
                end=mid-1;
                answer=mid;
            }else{
                start=mid+1;
            }
        }
        return answer;
    }
}