import java.util.LinkedList;
import java.util.Queue;
class Solution {
    static int[] dr = {0,0,-1,1};
    static int[] dc = {1,-1,0,0};
    static int M, N;
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        M = m;
        N = n;
        boolean[][] chk = new boolean[m][n];
        for(int r = 0;r<m;r++){
            for(int c = 0;c<n;c++){
                if(picture[r][c] != 0 && !chk[r][c]){
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea,bfs(r,c,picture,chk,picture[r][c]));
                }
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    static int bfs(int r, int c, int[][] map, boolean[][] chk, int target){
        int cnt = 1;
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(r,c));
        chk[r][c] = true;
        
        while(!q.isEmpty()){
            Pos tmp = q.poll();
            for(int d = 0; d< 4; d++){
                int nr = tmp.r + dr[d];
                int nc = tmp.c + dc[d];
                
                if(mapChk(nr, nc) && !chk[nr][nc] && map[nr][nc] == target){
                    q.add(new Pos(nr, nc));
                    chk[nr][nc] = true;
                    cnt++;
                }
                
            }
        }
        
        
        return cnt;
    }
    static boolean mapChk(int r, int c ){
        if(r < 0 || r >= M || c< 0 || c>= N)
            return false;
        return true;
    }
    
    static class Pos{
        int r,c;
        public Pos(int r, int c ){
            this.r = r;
            this.c = c;
        }
    }
}