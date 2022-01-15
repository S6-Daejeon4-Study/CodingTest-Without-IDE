class Solution {
    static int N , ans;
    static int[][] dp;
    
    int solution(int[][] land) {
        ans = Integer.MIN_VALUE;
        N = land.length;
        dp = new int[N][4];
        
        for(int j = 0 ; j < 4 ; j++){
            dp[0][j] = land[0][j];
        }
        
        for(int i = 1 ; i < N ; i++){
            for(int j = 0 ; j < 4 ; j ++){
                for(int k = 0 ; k < 4 ; k++){
                    if(j == k) continue;
                    int val = land[i][j] + dp[i-1][k];
                    dp[i][j] = val > dp[i][j] ? val : dp[i][j];
                }
            }
        }
        
        for(int j = 0 ; j < 4 ; j++){
            ans = ans > dp[N-1][j] ? ans : dp[N-1][j]; 
        }
        return ans;
    }
    

}