import java.util.*;
class Solution {
    public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        ArrayList<Integer>[] road = new ArrayList[n+1];
        for(int i = 0; i < n+1;i++){
            road[i] = new ArrayList<>();    
        }   
        
        for(int i = 0; i < m ; i++){
            int a = edge_list[i][0];
            int b = edge_list[i][1];
            road[a].add(b);
            road[b].add(a);
        }
        int[][] DP = new int[k][n+1];
        
        
        for(int i = 0; i < k ; i++){
            Arrays.fill(DP[i], Integer.MAX_VALUE);
        }
        
        DP[0][gps_log[0]] = 0; 
        
        for(int now = 1; now < k; now++){
            for(int pos = 1; pos <= n; pos++){ 
                DP[now][pos] = Math.min(DP[now][pos], DP[now-1][pos]);
                for(int ex : road[pos]){ 
                        DP[now][pos] = Math.min(DP[now][pos],DP[now-1][ex]);
                }
                if(pos!=gps_log[now] && DP[now][pos] != Integer.MAX_VALUE) DP[now][pos]+=1;
            }
        }
        
        
        // for(int now = 0; now < k; now++){ // 1초부터 마지막 k-1초 까지
        //     for(int pos = 1; pos <= n; pos++){ // 1반 위치부터 n번 위치까지 now-1시간 위치
        //         System.out.print(DP[now][pos]==Integer.MAX_VALUE ? "X" : DP[now][pos]);
        //     }
        //     System.out.println();
        // }
        
     
        return DP[k-1][gps_log[k-1]] != Integer.MAX_VALUE ? DP[k-1][gps_log[k-1]] : -1;
    }
    
}