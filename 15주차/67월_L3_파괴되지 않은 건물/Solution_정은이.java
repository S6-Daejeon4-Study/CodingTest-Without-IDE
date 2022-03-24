class Solution {
    int[][] skillMap;
    int N,M;
    public int solution(int[][] board, int[][] skill) {  
        N = board.length;
        M = board[0].length;
        skillMap = new int[N+1][M+1];
        for(int[] s: skill){
            useSkill(s);
        }
        getPrefixSum();
        return countBuilding(board);
    }
    public void useSkill(int[] s){
        int degree = s[5]*(s[0]==1?-1:1);
        skillMap[s[1]][s[2]]+=degree;
        skillMap[s[3]+1][s[4]+1]+=degree;
        degree*=-1;
        skillMap[s[3]+1][s[2]]+=degree;
        skillMap[s[1]][s[4]+1]+=degree;
        
    }
    public void getPrefixSum(){
        for(int i=0; i < N;i++){
            for(int j=1; j< M;j++)
                skillMap[i][j]+=skillMap[i][j-1];
        }
        for(int j=0; j < M;j++){
            for(int i=1; i < N;i++)
                skillMap[i][j]+=skillMap[i-1][j];
        }
        
    }
    public int countBuilding(int[][] board){
        int cnt=0;
        for(int i=0; i < N;i++){
            for(int j=0; j < M;j++){
                board[i][j]+=skillMap[i][j];
                if(board[i][j]>=1) cnt++;
            }
        }
        return cnt;
    }
}