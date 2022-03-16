class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int N = arr1.length;
        int M = arr2[0].length;
        
        int[][] answer = new int[N][M];
        for(int n=0;n<N;n++){
            for(int m=0;m<M;m++){
                int tmp=0;
                for(int a=0; a < arr1[0].length;a++){
                 tmp+=arr1[n][a]*arr2[a][m];   
                }
                answer[n][m]=tmp;
            }
        }
        return answer;
    }
}