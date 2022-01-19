import java.util.*;
class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] map = new int[N][N];
        for(int i=0; i<N;i++){
            Arrays.fill(map[i],10001*N);
            map[i][i]=0;
        }
        for(int[] r : road){
            int x =r[0]-1;
            int y =r[1]-1;
            map[y][x]=map[x][y]=Math.min(map[x][y],r[2]);

        }
        
        int[][] distance = new int[N][N];
        for(int i=0; i<N;i++){
           for(int j=0; j<N;j++){
               distance[i][j]=map[i][j];
           }
        }
        for(int k=0; k<N;k++){//경
            for(int i=0; i<N;i++){//출
                for(int j=0; j<N;j++){//도
                    distance[i][j]=Math.min(distance[i][k]+distance[k][j],distance[i][j]);
                }
            }
        }
        for(int i=0; i<N;i++){
            if(distance[0][i]<=K) answer++;
        }
        // System.out.print(Arrays.toString(distance[0]));
        return answer;
    }
}