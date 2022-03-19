class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int[] D = new int[n+1];
        D[0]=0;
        D[1]=1;
        D[2]=2;
        for(int i=3;i<=n;i++){
            D[i] = (D[i-2]+D[i-1])%1000000007;
        }
        answer = D[n];
        return answer;
    }
}