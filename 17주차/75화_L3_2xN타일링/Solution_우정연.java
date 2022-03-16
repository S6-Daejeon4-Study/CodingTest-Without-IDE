import java.util.*;
class Solution {
    class Solution {
        long[] dp;
        public int solution(int n) {
            dp = new long[n + 1];
            dp[0] = dp[1] = 1;
            for(int i = 2 ; i <= n ; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
            }

            return (int)dp[n];
        }
    }
}