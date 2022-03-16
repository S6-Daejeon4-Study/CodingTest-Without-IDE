class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int rlen = arr1.length;
        int clen = arr2[0].length;
        int len = arr1[0].length;
        int[][] answer = new int[rlen][clen];
        
        for(int r= 0;r<rlen;r++){
            for(int c = 0;c<clen;c++){
                for(int i = 0; i < len;i++){
                    answer[r][c] += arr1[r][i] * arr2[i][c];    
                }
            }
        }
        
        return answer;
    }
}