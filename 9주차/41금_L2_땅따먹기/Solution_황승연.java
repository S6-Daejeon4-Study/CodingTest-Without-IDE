class Solution {
    int solution(int[][] land) {
        int answer = 0;
    
        int size = land.length;
        int[][] D = new int[size][4];
        
        for(int i=0;i<4;i++){
            D[0][i] = land[0][i];
        }
        
        for(int i=1;i<size;i++){
            for(int j=0;j<4;j++){
                int max=0;
                for(int k=0;k<4;k++){
                    if(j==k){
                        continue;
                    }           
                    max= Math.max(max,D[i-1][k]);
                }
                D[i][j] = max+land[i][j];
            }
        }
        
        for(int i=0;i<4;i++){
            answer = Math.max(answer,D[size-1][i]);
        }

        return answer;
    }
}