class Solution {
    static int max;
    static int[] di ={-1,1,0,0};
    static int[] dj={0,0,-1,1};
    static boolean[][] visited;
    static int M;
    static int N;
    static int size;
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[] answer = new int[2];
        
        M=m;
        N=n;
        
        visited= new boolean[m][n];
        max=0;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && picture[i][j] !=0){
                    numberOfArea++;
                    size = 0;
                    dfs(i,j,picture[i][j],picture);
                    max= Math.max(max,size);
                }
            }
        }
        
        answer[0] = numberOfArea;
        answer[1] = max;
        
        return answer;
    }
    
    static void dfs(int nowi,int nowj,int color,int[][] picture){
        visited[nowi][nowj] = true;
        size++;
        for(int d=0;d<4;d++){
            int nexti = nowi+di[d];
            int nextj = nowj+dj[d];
            
            if(nexti<0 || nextj <0 || nexti>=M || nextj>=N || 
               picture[nexti][nextj] !=color || visited[nexti][nextj]){
                continue;
            }
            dfs(nexti,nextj,color,picture);
        }
    }
}