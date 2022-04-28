package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_20058 {
	static int[][] map;
	static int M,sum,maxSize;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  =new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		sum=0;
		maxSize=0;
		M = (int) Math.pow(2, N);
		map = new int[M][M];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < Q; i++) {
			int L = Integer.parseInt(st.nextToken());
			int gridSize = (int) Math.pow(2, L);
			fireStorm(gridSize);
		}
		
		count();
		
		System.out.println(sum);
		System.out.print(maxSize);
	}
	public static void fireStorm(int gridSize) {
		for (int i = 0; i < M; i+=gridSize) {
			for (int j = 0; j < M; j+=gridSize) {
				rotate(i, j, gridSize);
			}
		}	
		checkAdjSnow();
	}
	public static void rotate(int startX, int startY, int gridSize) {
		int[][] originalMap = new int[gridSize][gridSize];
		for (int i = 0; i < gridSize; i++) {
			for (int j = 0; j < gridSize; j++) {
				originalMap[i][j]=map[i+startX][j+startY];
			}
		}	
		
		for (int i = 0; i < gridSize; i++) {
			for (int j = 0; j < gridSize; j++) {
				map[i+startX][j+startY]=originalMap[gridSize-1-j][i];
			}
		}
		
		
	}
	public static void checkAdjSnow() {
		int[][] originalMap = new int[M][M];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				originalMap[i][j]=map[i][j];
			}
		}	
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				int cnt=0;
				if(originalMap[i][j]<0) continue;
				for (int d = 0; d < 4; d++) {
					int tx = i+dx[d];
					int ty = j+dy[d];
					
					if(isValidate(tx, ty)&&originalMap[tx][ty]>0) cnt++;
				}
				if(cnt<3) map[i][j]--;
			}
		}
		
	}
	public static void count() {
		boolean[][] visited = new boolean[M][M];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				if(!visited[i][j] && map[i][j]>0) bfsSnowBlock(i, j, visited);
			}
		}
	}
	public static void bfsSnowBlock(int i, int j, boolean[][] visited) {
		Queue<Pos> que = new LinkedList<Pos>();
		visited[i][j]=true;
		que.add(new Pos(i, j));
		int blockCnt =0;
		while(!que.isEmpty()) {
			Pos cur = que.poll();
			blockCnt++;
			sum += map[cur.x][cur.y];
			for (int d = 0; d < 4; d++) {
				int tx = cur.x+dx[d];
				int ty = cur.y+dy[d];
				
				if(isValidate(tx, ty)&&!visited[tx][ty]&&map[tx][ty]>0) {
					que.add(new Pos(tx, ty));
					visited[tx][ty]=true;
				}
			}
		}
		maxSize = Math.max(maxSize, blockCnt);
	}
	public static boolean isValidate(int x, int y ) {
		return x>=0 && y>=0 && x<M && y<M;
	}
	public static class Pos{
		int x,y;
		public Pos(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
}
