class Solution {
    static boolean[] visited;
    static boolean[][] adjMatrix;
    static int n;
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        this.n=n;
        adjMatrix = new boolean[n+1][n+1];
        for(int i=0;i<results.length;i++){
            int win = results[i][0];
            int lose = results[i][1];
            adjMatrix[win][lose]=true;
        }
        
        for(int i=1;i<=n;i++){
            visited = new boolean[n+1];
            dfs(i,1);
            dfs(i,2);
            
            boolean flag=true;
            for(int j=1;j<=n;j++){
                if(!visited[j]){
                    flag=false;
                    break;
                }
            }
            if(flag){
                answer++;
            }
        }
        
        return answer;
    }
    
    static void dfs(int current,int type){
        visited[current]=true;
        
        if(type==1){
            for(int i=1;i<=n;i++){
                if(!visited[i] && adjMatrix[current][i]){
                    dfs(i,type);
                }
            }   
        }else{
            for(int i=1;i<=n;i++){
                if(!visited[i] && adjMatrix[i][current]){
                    dfs(i,type);
                }
            }
        }
    }
}