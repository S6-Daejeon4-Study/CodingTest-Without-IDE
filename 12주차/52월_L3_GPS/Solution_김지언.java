import java.util.*;

class Solution {
    class Link {
        int node;
        Link next;
        
        Link(int node, Link next) {
            this.node = node;
            this.next = next;
        }
    }
    
    public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        Link[] edges = new Link[n+1];
        int[][] dp = new int[k][n+1];
        
        for(int i = 0; i < k ; i++){
            Arrays.fill(dp[i], k);
        }
        
        for(int i = 0; i < edge_list.length; i++) {
            int a = edge_list[i][0];
            int b = edge_list[i][1];
            
            edges[a] = new Link(b, edges[a]);
            edges[b] = new Link(a, edges[b]);
        } 
        
        dp[0][gps_log[0]] = 0; 

        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[i].length; j++){
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]); // 이동 X
                
                // 이동 O
                Link next = edges[j];
                while(next != null) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][next.node]);
                    next = next.next;
                }
                
                if(j != gps_log[i])
                    dp[i][j]++;
            }
        }
         
        return dp[k-1][gps_log[k-1]] == k ? -1 : dp[k-1][gps_log[k-1]];
    }
}