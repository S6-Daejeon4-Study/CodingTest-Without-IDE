class Solution {
    int N,M;
    int[] dx ={1,0,-1,0};
    int[] dy ={0,-1,0,1};
    boolean[][] visited;
    public boolean solution(int[][] key, int[][] lock) {
        M=key.length;
        N=lock.length;
        visited = new boolean[M][M];
        
        int[][] map = new int[N+2*(M-1)][N+2*(M-1)];
        for(int i = M-1 ; i < N+M-1 ; i++) {
            for(int j = M-1 ; j < N+M-1 ; j++) {
                map[i][j]=lock[i-M+1][j-M+1];          
            }
        }
        for(int i = 0 ; i < 4 ; i++) {
            if(isValidateKey(key,map)) return true;
            int[][] rotateKey = rotate(key);
            key=rotateKey;
        }
        
        return false;
    }
    
    public int[][] rotate(int[][] key){
        int[][] rotateKey = new int[M][M];
        for(int i = 0 ; i < M ; i++) {
            for(int j = 0 ; j < M ; j++) {
                rotateKey[M - j - 1][i] = key[i][j];
            }
        }
        return rotateKey;
    }
    public boolean isValidate(int i, int j){
        return (i>= 0&& i<M&&j>= 0&& j<M);
    }

    public boolean isValidateKey(int[][] key,int[][] lock){
        for(int i = 0; i < N+2*M-1 ; i++) {
            for(int j = 0 ; j <N+2*M-1 ; j++) {
                if(unlock(i,j,key,lock)) return true;            
            }
        }
        return false;
    }
    public boolean unlock(int startKeyX, int startKeyY, int[][] key, int[][] lock){
        int endKeyX = startKeyX+M;
        int endKeyY = startKeyY+M;
        
        for(int i=M-1;i<N+M-1;i++){
            for(int j=M-1;j<N+M-1;j++){
                if(i>=startKeyX&&i<endKeyX&&j>=startKeyY&&j<endKeyY){
                    if(lock[i][j]==key[i-startKeyX][j-startKeyY]) return false;  
                }
                else if(lock[i][j]==0){
                    return false;  
                }
            }
        } 
        return true;
    }
}