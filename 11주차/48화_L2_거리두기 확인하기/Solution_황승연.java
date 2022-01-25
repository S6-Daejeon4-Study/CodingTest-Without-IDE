import java.util.*;

class Solution {
    static char[][] map;
    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(int k=0;k<5;k++){
            map = new char[5][5];
            List<Point> list = new ArrayList<>();
            
            for(int i=0;i<5;i++){
                String str = places[k][i];
                for(int j=0;j<5;j++){
                    map[i][j] = str.charAt(j);
                    if(map[i][j]=='P'){
                        list.add(new Point(i,j));
                    }
                }
            }
            
            boolean flag = false;
            
            for(int i=0;i<list.size();i++){
                if(flag){
                    break;
                }
                for(int j=i+1;j<list.size();j++){
                    int distance = Math.abs(list.get(i).i-list.get(j).i)+Math.abs(list.get(i).j-list.get(j).j);
                    if(distance<=2){
                        int dist = bfs(list.get(i).i,list.get(i).j,list.get(j).i,list.get(j).j);
                        if(dist<=2){
                            flag = true;
                            break;
                        }
                    }
                }
            }
            
            if(flag){
                answer[k] = 0;
            }else{
                answer[k]=1;
            }
            
        }
        
        return answer;
    }
    
    static int bfs(int si,int sj,int ei,int ej){
        boolean[][] visited = new boolean[5][5];
        Queue<Point> queue = new LinkedList<>();
        
        visited[si][sj] = true;
        queue.offer(new Point(si,sj));
        
        int dist = 0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                Point current = queue.poll();
                int nowi = current.i;
                int nowj = current.j;
                
                if(nowi==ei && nowj==ej){
                    return dist;
                }
                
                for(int d=0;d<4;d++){
                    int nexti = nowi+di[d];
                    int nextj = nowj+dj[d];
                    
                    if(nexti<0 || nextj <0 || nexti>=5 || nextj>=5 || 
                       visited[nexti][nextj] || map[nexti][nextj] =='X'){
                        continue;
                    }
                    queue.offer(new Point(nexti,nextj));
                    visited[nexti][nextj] = true;
                }
            }
            dist++;
        }
        return 10;
    }
    
    static class Point{
        int i;
        int j;
        public Point(int i,int j){
            this.i = i;
            this.j = j;
        }
    }
}