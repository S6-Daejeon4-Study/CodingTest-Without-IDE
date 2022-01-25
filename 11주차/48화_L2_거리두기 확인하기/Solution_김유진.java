import java.util.*;
class Solution {
    static char[][] map;
    static int[] dr = {0,0,1,-1};
    static int[] dc = {1,-1,0,0};
    public int[] solution(String[][] places) {
        int len = places.length;
        int[] answer = new int[len];
        for(int i = 0; i < len; i++){
            map = new char[5][5];
            for(int j = 0; j < 5; j++){
                map[j] = places[i][j].toCharArray();
                // System.out.println(Arrays.toString(map[j]));
            }
            
            answer[i] = chk() ? 1 : 0;
            // System.out.println();
            
        }
        
        
        return answer;
    }
    static boolean chk(){
        for(int r = 0; r < 5; r++){
            for(int c = 0; c < 5; c++){
                if(map[r][c] == 'P'){   
                    // System.out.println(r+", "+c);
                    if(bfs(r,c)){
                        // System.out.println("out : " + r+", "+c);
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    static boolean bfs(int r, int c){
        Queue<Pos> q = new LinkedList<>();
        boolean[][] chkMap = new boolean[5][5];
        chkMap[r][c] = true;
        q.add(new Pos(r,c));
        int time = 0;
        while(!q.isEmpty() && time != 2){
            int size = q.size();
            for(int idx = 0; idx < size; idx++){
                Pos tmp = q.poll();
                // System.out.println("bfs : " + tmp.r + ", " + tmp.c);
                for(int d = 0; d < 4; d++){
                    int nr = tmp.r + dr[d];
                    int nc = tmp.c + dc[d];
                    if(nr < 0 || nc < 0 || nr >= 5 || nc >= 5 || chkMap[nr][nc] || map[nr][nc] == 'X')
                        continue;
                    else if(map[nr][nc] == 'P')
                        return true;
                    else{
                        q.add(new Pos(nr, nc));
                        chkMap[nr][nc] = true;
                    }
                }
            }
            time++;
            // System.out.println(time);
        }
        return false;
    }
    
    static class Pos{
        int r, c;
        private Pos(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}