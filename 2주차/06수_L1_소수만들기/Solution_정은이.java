class Solution {
    int[] prime = new int[3];
    int cntPrimeNumber=0;
    public int solution(int[] nums) {
        comb(0,0,nums);
        return cntPrimeNumber;
    }
    public void comb(int a, int cnt,int[] nums){
        if(cnt>=3){
            int sum=0;
            for(int i=0; i<3;i++){
                sum+=prime[i];
            }
            if(isPrimeNumber(sum)) cntPrimeNumber+=1;
            return;
        }
        if(a==nums.length) return;
        for(int j=a;j<nums.length;j++){
            prime[cnt]=nums[j];
            comb(j+1,cnt+1,nums);
        }
    }
    public boolean isPrimeNumber(int n){
        for(int i=2;i<n;i++){
            if(n%i==0) return false;
        }
        return true;
    }
}