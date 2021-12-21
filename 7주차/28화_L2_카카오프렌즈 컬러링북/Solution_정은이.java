import java.util.*;
class Solution {
    boolean[][] visited;
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        visited = new boolean[m][n];
        
        for(int i=0; i< m;i++){
            for(int j=0; j<n;j++){
                if(!visited[i][j]&&picture[i][j]!=0){
                    numberOfArea++;
                    maxSizeOfOneArea=Math.max(maxSizeOfOneArea,bfs(i,j,picture));
                }
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    public int bfs(int i, int j,int[][] picture){
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        int M= picture.length;
        int N= picture[0].length;
        int type = picture[i][j];
        
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{i,j});
        visited[i][j]=true;
        int cnt=0;
        while(!que.isEmpty()){
            int[] current=que.poll();
            cnt++;
            
            for(int d=0; d<4;d++){
                int tx = current[0]+dx[d];
                int ty = current[1]+dy[d];
                if(tx<0|| tx>=M||ty<0||ty>=N||visited[tx][ty]) continue;
                if(picture[tx][ty]==type){
                    visited[tx][ty]=true;
                    que.add(new int[]{tx,ty});
                }
            }
            
        }
        return cnt;
    }
}