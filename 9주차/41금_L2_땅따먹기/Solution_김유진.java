class Solution {
    int solution(int[][] land) {
        
        int len = land.length;
        int dp[][] = new int[len][4];
        dp[0] = land[0];
        
        for(int i = 1; i< len ; i++){
            for(int j = 0; j < 4; j++){
                dp[i][j] = land[i][j] + selectNum(j, dp[i-1]);
            }
        }
        int answer = 0;
        for(int j = 0; j < 4; j++){
            answer = Math.max(answer, dp[len-1][j]);
        }
        
        return answer;
    }
    
    static int selectNum(int j, int[] num){
        int max = 0;
        for(int i = 0; i< 4; i++){
            if (i != j){
                max = Math.max(num[i],  max);
            }
        }
        return max;
    }
}