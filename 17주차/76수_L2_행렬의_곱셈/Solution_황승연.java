class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        
        int size1 = arr1.length;
        int size2 = arr2[0].length;
        int size3 = arr1[0].length;
        
        int[][] answer = new int[size1][size2];
        
        for(int i=0;i<size1;i++){
            for(int j=0;j<size2;j++){
                int sum=0;
                for(int k=0;k<size3;k++){
                    sum+=arr1[i][k]*arr2[k][j];
                }
                answer[i][j]=sum;
            }
        }
        
        return answer;
    }
}