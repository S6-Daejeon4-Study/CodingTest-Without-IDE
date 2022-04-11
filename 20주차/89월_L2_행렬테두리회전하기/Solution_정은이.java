class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int length = queries.length;
        int[] answer = new int[length];
        int[][] arr = new int[rows+1][columns+1];
        init(arr);
        for(int a=0; a<length;a++ ){
            answer[a]=rotate(arr, queries[a]);
        }
        return answer;
    }
    public void init(int[][] arr){
        int num=1;
        for(int i=1; i<arr.length;i++ ){
            for(int j=1; j<arr[0].length;j++ ){
                arr[i][j]=num++;
            }
        }
    }
    public int rotate(int[][] arr,int[] query){
       
        int tmp = arr[query[0]][query[1]];
        
        int min = tmp;
        for(int i=query[0]+1; i<=query[2];i++ ){
           arr[i-1][query[1]]= arr[i][query[1]];
            min = Math.min(min, arr[i-1][query[1]]);
        }
        for(int j=query[1]+1; j<=query[3];j++ ){
            arr[query[2]][j-1]= arr[query[2]][j];
            min = Math.min(min, arr[query[2]][j-1]);
        }
        for(int i=query[2]-1; i>=query[0];i-- ){
           arr[i+1][query[3]]= arr[i][query[3]];
            min = Math.min(min, arr[i+1][query[3]]);
        }
        for(int j=query[3]-1; j>=query[1]+1;j-- ){
            arr[query[0]][j+1]= arr[query[0]][j];
            min = Math.min(min, arr[query[0]][j+1]);
        }
        arr[query[0]][query[1]+1]=tmp;
        return min;
    }
}