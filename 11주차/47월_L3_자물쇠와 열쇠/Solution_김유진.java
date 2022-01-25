class Solution {
    static int[][] map;
    static int[][] newKey;
    static int m,n;
    public boolean solution(int[][] key, int[][] lock) {
        m = key.length;
        n = lock.length;
        map = new int[n+(m-1)*2][n+(m-1)*2];
        newKey = new int[m][m];

        for(int r = m - 1; r < m + n - 1; r++){
            for(int c = m - 1; c < m + n - 1; c++){
                map[r][c] = lock[r-m+1][c-m+1];
            }
        }
        
        for(int r = 0; r < m; r++){
            for(int c = 0; c < m; c++){
                newKey[r][c] = key[r][c];
            }
        }
        
        for(int rota = 0; rota < 4; rota++){
            rotateMatrix();
            // printNewKey();
            // System.out.println();
            if(chkUnlock())
                return true;
        }
        return false;
    }
    
    static void printNewKey(){
        for(int r= 0; r<m ; r++){
            for(int c = 0; c<m;c++){
                System.out.print(newKey[r][c]+" ");
            }
            System.out.println();
        }
    }
    
    static boolean chkUnlock(){
        for(int a = 0; a < n + m - 1; a++){
            for(int b = 0; b < n + m - 1; b++){
                // System.out.println(a+", "+b);
                if(chkMap(a,b))
                    return true;
                // System.out.println();
            }
        }
        return false;
    }
    
    static boolean chkMap(int a, int b){
        for(int r = m - 1; r < m + n - 1; r++){
            for(int c = m - 1; c < m + n - 1; c++){
                int nr = r - a;
                int nc = c - b;
                if(map[r][c] == 1){ // 자물쇠가 돌기일때
                    if(nr < 0 || nc < 0 || nr >= m || nc >= m) // 키가 없으면 상관없다.
                        continue;
                    else{ // 키가 있으면서
                        if(newKey[nr][nc] == 1) // 키가 돌기라면
                            return false;
                    }
                }else{ // 자물쇠 홈일때
                    if(nr < 0 || nc < 0 || nr >= m || nc >= m || newKey[nr][nc] == 0) // 키가 없거나 키가 홈이면
                        return false;
                }
                // System.out.println("map : "+r+", "+c);
                // System.out.println("key : "+nr+", "+nc);
            }
        }
        return true;
    }
    
    static void rotateMatrix(){
        int[][] out = new int[m][m];
        int res = m - 1;
        for(int r = 0; r < m; r++){
            for(int c = 0;c < m; c++){
                int tmp = newKey[r][c];
                int nr = ((res) + (c*2 - (res))) / 2;
                int nc = ((res) - (r*2 - (res))) / 2;
                out[nr][nc] = tmp;
            }
        }
        newKey = out;
    }
}