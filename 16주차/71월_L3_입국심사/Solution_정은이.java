class Solution {
    public long solution(int n, int[] times) {
        long left =0;
        long right = (long)Math.pow(10,18);
        long mid =0;
        while(left <= right){
            mid = (left+right)/2;
            long screenPersonCnt = getAvailableScreen(mid,times);
            if(screenPersonCnt<n) left = mid+1;
            else right = mid-1;
        }
        return left;
    }
    
    public long getAvailableScreen(long time , int[] times){
        long personCnt=0;
        for(int t : times){
            personCnt+=time/t;
        }
        return personCnt;
    }
}