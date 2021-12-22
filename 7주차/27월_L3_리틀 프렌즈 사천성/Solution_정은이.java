import java.util.*;
class Solution {
    char[][] originMap;
    char[][] map;
    char[] spells;
    char[] order;
    boolean[] used;
    int R,M,N;
    boolean isFirst=false;
    String answer;
    HashMap<String,int[]> posMap;
    public String solution(int m, int n, String[] board) {
        answer = "IMPOSSIBLE";
        String spell="";
        M=m;
        N=n;
        isFirst=false;
        map= new char[M][N];
        originMap= new char[M][N];
        posMap= new HashMap<>();
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                originMap[i][j]=board[i].charAt(j);
                if(originMap[i][j]!='.'&&originMap[i][j]!='*'){
                    if(!spell.contains(originMap[i][j]+"")) {
                        spell+=originMap[i][j];
                        posMap.put(originMap[i][j]+"",new int[]{i,j,0,0});
                    }
                    else {
                        posMap.get(originMap[i][j]+"")[2]=i;
                        posMap.get(originMap[i][j]+"")[3]=j;
                    }
                }
                
                 map[i][j]=originMap[i][j];
            }
        }
        spells=spell.toCharArray();
        Arrays.sort(spells);
        R=spells.length;
        order= new char[R];
        used=new boolean[R];
        perm(0);
        
        return answer;
    }
    public void perm(int idx){
        if(isFirst) return;
        if(idx ==R) {
            StringBuilder sb = new StringBuilder();
            for(char c:order){
                sb.append(c);
            }
            answer=sb.toString();
            isFirst=true;
			return;
		}
		for (int i = 0; i < R ; i++) {           
		    if(used[i]) continue;
            if(!findPair(spells[i])) continue;
            order[idx] = spells[i];
            used[i] = true;
            perm(idx+1);
		}
    }

    public boolean findPair(char tileType){

        int[] pos = posMap.get(tileType + "");
        int i = pos[0];
        int j = pos[1];
        int targerI = pos[2];
        int targerJ = pos[3];

        Queue<int[]> que = new LinkedList<>();

        int difx = targerI - i;
        if (difx > 0) difx = 1;
        if (difx < 0) difx = -1;
        int dify = targerJ - j;
        if (dify > 0) dify = 1;
        if (dify < 0) dify = -1;

        for (int k = 0; k < 2; k++) {
            que.clear();
            que.add(new int[]{i, j});
            while (!que.isEmpty()) {
                int[] current = que.poll();
                if (targerI == current[0] && targerJ == current[1]) {
                    map[i][j] = '.';
                    map[current[0]][current[1]] = '.';
                    return true;
                }
                int ti = current[0];
                int tj = current[1];
                if(k==0){
                    if (targerI == current[0]) { // 행이같을때,열움직이기
                        tj += dify;
                    } else { // 여기가 처음 ! 행 움직이기
                        ti += difx;
                    }
                }
                else{
                    if (targerJ == current[1]) { // 열이 같을때,행 움직이기
                        ti += difx;
                    } else { // 여기가 처음 ! 열 움직이기
                        tj += dify;
                    }
                }

                if (map[ti][tj] != '.' && map[ti][tj] != tileType)break;
                que.add(new int[]{ti, tj});
            }
        }

        return false;
    }
}