import java.util.*;
class Solution {
    int N,M;
    public int[] solution(String[] grid) {
        ArrayList<Integer> list = new ArrayList<>();
        N= grid.length;
        M= grid[0].length();
        char[][] map = new char[N][M];
        for(int i=0;i<N;i++){
            map[i]=grid[i].toCharArray();
        }
        int[] dx={1,0,-1,0}; //남 동 북 서 L 기준
        int[] dy={0,1,0,-1};
        boolean[][][] visited = new boolean[N][M][4];
        for(int i=0;i<N;i++){
           for(int j=0;j<M;j++){
               for(int d=0;d<4;d++){
                   
                    if(visited[i][j][d]) continue;
                    int ti=i;
                    int tj=j;
                    int td=d;
                    int cnt=0;
                    while(true){
                        if(visited[ti][tj][td]) break;
                        else{
                            cnt++;
                            visited[ti][tj][td]=true;
                        }
                        if(map[ti][tj]=='R'){
                            td-=1;
                            if(td==-1) td=3;
                        }else if(map[ti][tj]=='L'){
                            td+=1;
                            if(td==4) td=0;
                        }
            
                        ti+=dx[td];
                        tj+=dy[td];
                        if(ti==-1) ti=N-1;
                        if(ti==N) ti=0;
                        if(tj==-1) tj=M-1;
                        if(tj==M) tj=0;
                        
                    }
                    if(cnt>0)list.add(cnt);
                }
            }
        }
        
        Collections.sort(list);
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i]=list.get(i);
        }
        return answer;
    }
}