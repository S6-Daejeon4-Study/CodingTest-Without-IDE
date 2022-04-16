class Solution {
    static int[] di = {1,0,-1,0};
    static int[] dj = {0,1,0,-1};
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        int[][] map = new int[rows][columns];
        int number=1;
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                map[i][j]=number++;
            }
        }
        
        for(int i=0;i<queries.length;i++){
            int[] arr = queries[i];
            int r1 = arr[0]-1;
            int r2 = arr[2]-1;
            int c1 = arr[1]-1;
            int c2 = arr[3]-1;
            
            int temp = map[r1][c1];
            if(rows==3 && columns==3){
                for(int n=0;n<rows;n++){
                    for(int m=0;m<columns;m++){
                        System.out.print(map[n][m]+" ");
                    }
                    System.out.println();
                }
                
            }
            System.out.println();
            int nowi = r1;
            int nowj = c1;
            int d=0;
            int min = temp;
            for(int j=0;j<(r2-r1+c2-c1)*2-1;j++){
                
                int nexti = nowi+di[d];
                int nextj = nowj+dj[d];
                if(nexti>r2 || nextj>c2 || nexti<r1 || nextj<c1){
                    d++;
                    if(d>3){
                        d=0;
                    }
                    nexti= nowi+di[d];
                    nextj= nowj+dj[d];
                }
                map[nowi][nowj]=map[nexti][nextj];
                nowi= nexti;
                nowj=nextj;
                min = Math.min(min,map[nowi][nowj]);
            }
            map[nowi][nowj]=temp;
            answer[i]=min;
        }
        return answer;
    }
}