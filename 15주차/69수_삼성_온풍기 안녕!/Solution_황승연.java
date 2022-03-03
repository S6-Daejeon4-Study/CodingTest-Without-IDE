package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_23289_온풍기안녕 {

	static int[] di = {-1,0,1,0};
	static int[] dj = {0,1,0,-1};
	static int R,C,K,W;
	static int[][] map;
	static int[][][][] wall;
	static int[][] sum;
	static int[][] temp;
	static boolean[][] visited;
	static List<Point> windMaker;
	static List<Point> checkList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		windMaker = new ArrayList<>();
		checkList = new ArrayList<>();
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]>0) {
					if(map[i][j]==5) {
						checkList.add(new Point(i, j));
					}else {
						int num = map[i][j];
						if(num==3) {
							num=0;
						}else if(num==2) {
							num=3;
						}else if(num==4) {
							num=2;
						}
						windMaker.add(new Point(i, j, num));
					}
				}
			}
		}
		
		W = Integer.parseInt(br.readLine());
		wall = new int[R][C][R][C];
		for(int i=0;i<W;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int t = Integer.parseInt(st.nextToken());
			
			
			if(t==0) {
				wall[x][y][x-1][y]=1;
				wall[x-1][y][x][y]=1;
			}else {
				wall[x][y][x][y+1]=1;
				wall[x][y+1][x][y]=1;
			}
		}
		//입력 끝
		
		int cho=0;
		sum = new int[R][C];
		while(true) {
			//1.바람 나옴
			wind();
			
			//2.온도 조절
			control();
			
			//3.바깥 칸 1씩 감소
			decrease();
			//4.초콜렛 섭취
			cho++;
			if(cho>100) {
				break;
			}
			//5.
			if(check()) {
				System.out.println(cho);
				return;
			}
		}
		System.out.println(101);

	}
	
	static boolean check() {
		
		for(int i=0;i<checkList.size();i++) {
			Point cur = checkList.get(i);
			int nowi = cur.i;
			int nowj = cur.j;
			if(sum[nowi][nowj]<K) {
				return false;
			}
		}
		return true;
	}
	
	static void decrease() {
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(i==0 || j==0 || i==R-1 || j==C-1) {
					if(sum[i][j]>0) {
						sum[i][j] -=1;						
					}
				}
			}
		}
	}
	
	static void control() {
		temp = new int[R][C];
		visited = new boolean[R][C];
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				int num = sum[i][j];
				
				for(int d=0;d<4;d++) {
					int nexti = i+di[d];
					int nextj = j+dj[d];
					
					if(out(nexti,nextj) || visited[nexti][nextj]) {
						continue;
					}
					if(wall[i][j][nexti][nextj]==1 || wall[nexti][nextj][i][j]==1) {
						continue;
					}

					int compare = sum[nexti][nextj];
					if(num>compare) {
						int diff = (num-compare)/4;
						temp[i][j] -= diff;
						temp[nexti][nextj] +=diff;
					}else if(num<compare) {
						int diff = (compare-num)/4;
						temp[i][j] += diff;
						temp[nexti][nextj] -=diff;
					}
				}
				visited[i][j]=true;
			}
		}
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				sum[i][j]+=temp[i][j];
			}
		}
	}
	
	static void wind() {
		
		for(int k=0;k<windMaker.size();k++) {
			Point cur = windMaker.get(k);
			int d = cur.d;
			temp = new int[R][C];
			
			int nowi = cur.i+di[d];
			int nowj = cur.j+dj[d];
			
			visited = new boolean[R][C];
			dfs(nowi,nowj,d,0);
			
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					sum[i][j]+=temp[i][j];
				}
			}
		}
		
	}
	
	static void dfs(int nowi,int nowj,int d,int depth) {
		visited[nowi][nowj]=true;
		
		temp[nowi][nowj] = 5-depth;
		
		if(depth>=4) {
			return;
		}
		for(int k=-1;k<=1;k++) {
			int nd = d+k;
			if(nd<0) nd=3;
			if(nd>3) nd=0;
			
			int nexti = nowi+di[nd];
			int nextj = nowj+dj[nd];
			
			int realni = nexti+di[d];
			int realnj = nextj+dj[d];
			
			if(k!=0) {
				if(out(realni,realnj)) {
					continue;
				}
				if((wall[nowi][nowj][nexti][nextj]==1 || wall[nexti][nextj][nowi][nowj]==1) || 
						(wall[realni][realnj][nexti][nextj]==1 || wall[nexti][nextj][realni][realnj]==1)) {
					continue;
				}
				if(!visited[realni][realnj]) {
					dfs(realni,realnj,d,depth+1);
				}
			}else {
				if(out(nexti,nextj)) {
					continue;
				}
				if(wall[nowi][nowj][nexti][nextj]==1 || wall[nexti][nextj][nowi][nowj]==1) {
					continue;
				}

				if(!visited[nexti][nextj]) {
					dfs(nexti,nextj,d,depth+1);					
				}
			}
		}
	}
	
	static boolean out(int nexti,int nextj) {
		
		if(nexti<0 || nextj<0 || nexti>=R || nextj>=C) {
			return true;
		}
		return false;
	}
	
	static class Point{
		int i;
		int j;
		int d;
		public Point(int i, int j, int d) {
			super();
			this.i = i;
			this.j = j;
			this.d = d;
		}
		public Point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
		
	}

}
