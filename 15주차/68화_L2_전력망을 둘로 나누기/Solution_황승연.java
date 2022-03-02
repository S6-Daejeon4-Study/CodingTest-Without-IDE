import java.util.*;

class Solution {
    static boolean[] visited;
    static int min;
    static int count;
    static boolean[][] copy;
    public int solution(int n, int[][] wires) {
        min = Integer.MAX_VALUE;
        
        boolean[][] adjMatrix = new boolean[n][n];
        for(int i=0;i<wires.length;i++){
            int from = wires[i][0]-1;
            int to = wires[i][1]-1;
            adjMatrix[from][to] = true;
            adjMatrix[to][from] = true;
        }
        
        for(int k=0;k<wires.length;k++){
            int checki = wires[k][0]-1;
            int checkj = wires[k][1]-1;
            
            copy = new boolean[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    copy[i][j] = adjMatrix[i][j];
                }
            }
            copy[checki][checkj]= false;
            copy[checkj][checki]= false;
            
            visited= new boolean[n];
            count=0;
            dfs(0,n);
            min = Math.min(min,Math.abs(n-count-count));
        }
        
        return min;
    }
    
    static void dfs(int current,int n){
        visited[current] = true;
        count++;
        
        for(int i=0;i<n;i++){
            if(!visited[i] && copy[current][i]){
                dfs(i,n);
            }
        }
    }
}