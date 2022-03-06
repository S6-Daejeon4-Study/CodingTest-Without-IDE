class Solution {
    public int solution(int[][] board, int[][] skill) {
        int rlen = board.length;
        int clen = board[0].length;
        int[][] nn = new int[rlen][clen];
        for(int r = 0;r<rlen;r++){
            for(int c =0;c<clen;c++){
                nn[r][c] = board[r][c];
            }
        }
        
        int[][] sum = new int[rlen+1][clen+1];
        
        for(int[] a : skill){
            int degree = a[0] == 1 ? -a[5] : a[5];
            
            sum[a[1]][a[2]] += degree;
            sum[a[3]+1][a[4]+1] += degree;
            sum[a[1]][a[4]+1] -= degree;
            sum[a[3]+1][a[2]] -= degree;
            
        }
        
        int answer = 0;
        
        for(int r = 0; r < rlen; r++){
            for(int c = 0; c < clen; c++){
                if(c != 0) sum[r][c] += sum[r][c-1];
             }
        }
        
        for(int c = 0; c < clen; c++){
            for(int r = 0; r < rlen; r++){
                if(r != 0) sum[r][c] += sum[r-1][c];
                nn[r][c] += sum[r][c];
                if(nn[r][c] > 0)
                    ++answer;
             }
        }
        
        // for(int r = 0; r < rlen; r++){
        //     for(int c = 0; c < clen; c++){
        //         System.out.print((nn[r][c] < 0 ? nn[r][c] : " "+nn[r][c]) + " ");
        //      }
        //     System.out.println();
        // }
        
        return answer;
    }
}