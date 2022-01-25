import java.util.*;
class Solution {
    final int size=5;
    public int[] solution(String[][] places) {
        int[] answer = new int[size];
        
        for(int i=0;i<size;i++){
            answer[i]=checkKeepDistance(places[i]);
        }
        
        return answer;
    }
    public int checkKeepDistance(String[] tables){
        char[][] map= new char[size][size];
        boolean[][] visited = new boolean[size][size];
        ArrayList<Pos> plist= new ArrayList<>();
        Queue<Pos> q =new LinkedList<>();
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        int keep=1;
        
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                map[i][j]=tables[i].charAt(j);
                if(map[i][j]=='P') plist.add(new Pos(i,j)); 
            }
        }
        
        for(Pos p : plist){
            for(int i=0;i<size;i++){
                Arrays.fill(visited[i],false);
            }
            q.clear();
            q.add(p);
            visited[p.x][p.y]=true;
            int distance=0;
            while(!q.isEmpty()){
                distance++;
                if(distance>3) break;
                int qSize = q.size();
                for(int i=0;i<qSize;i++){
                    Pos current = q.poll();
                    // System.out.println(current.x+" "+ty);
                    for(int d=0;d<4;d++){
                        int tx = current.x+dx[d];
                        int ty = current.y+dy[d];
                        if(tx<0||tx>=size||ty<0||ty>=size||visited[tx][ty]) continue;
                        if(map[tx][ty]=='O'){
                            visited[tx][ty]=true;
                            // System.out.println(tx+" "+ty);
                            q.add(new Pos(tx,ty));
                        }
                        if(map[tx][ty]=='P') return 0;
                    }
                } 
                distance++;
            }
        }
        return 1;
    }
    public class Pos{
        int x,y;
        public Pos(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
}