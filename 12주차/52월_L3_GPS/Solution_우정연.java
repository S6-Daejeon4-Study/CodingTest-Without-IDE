public class PRO1837_GPS {
    public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        boolean[][] edgeArr = new boolean[n + 1][n + 1];
        int[][] memo = new int[k][n + 1];
        for(int i = 0 ; i < m ; i++) {
            edgeArr[edge_list[i][0]][edge_list[i][1]] = true;
            edgeArr[edge_list[i][1]][edge_list[i][0]] = true;
        }
        for(int i = 0 ; i < n + 1 ; i++) {
            edgeArr[i][i] = true;
        }
        for(int j = 1 ; j < n + 1 ; j++) {
            int x = 0;
            if(!edgeArr[j][gps_log[0]]) x = -1;
            else if(j != gps_log[1]) x = 1;
            memo[1][j] = x;
        }
        for(int i = 2 ; i < k ; i++) {
            for(int j = 1 ; j < n + 1 ; j++) {
                int min = Integer.MAX_VALUE;
                for(int y = 1 ; y < n + 1 ; y++) {
                    if(!edgeArr[j][y]) continue;
                    if(memo[i - 1][y] == -1) continue;
                    int x = memo[i - 1][y];
                    if(j != gps_log[i]) x++;
                    min = Math.min(x, min);
                }
                if(min == Integer.MAX_VALUE) memo[i][j] = -1;
                else memo[i][j] = min;
            }
        }
        
        return memo[k - 1][gps_log[k - 1]];
    }
}
