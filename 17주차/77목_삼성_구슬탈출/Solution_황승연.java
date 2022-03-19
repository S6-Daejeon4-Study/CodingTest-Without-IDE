package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_13460_구슬탈출2_방문체크한버전 {

	static int N;
	static int M;
	static int goalI;
	static int goalJ;
	static char[][] temp;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static status current;
	static boolean redEscape;
	static boolean blueEscape;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		char[][] originMap = new char[N][M];
		int[] startBall = new int[4];
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				originMap[i][j]= str.charAt(j);
				if(originMap[i][j]=='O') {
					goalI=i;
					goalJ=j;
				}
				if(originMap[i][j]=='R') {
					startBall[0]=i;
					startBall[1]=j;
				}
				if(originMap[i][j]=='B') {
					startBall[2]=i;
					startBall[3]=j;
				}
			}
		}
		//입력 끝
		
		Queue<status> queue = new LinkedList<>();
		queue.offer(new status(0, originMap, startBall[0], startBall[1], startBall[2], startBall[3]));
		boolean[][][][] visited = new boolean[10][10][10][10];
		visited[startBall[0]][startBall[1]][startBall[2]][startBall[3]]=true;
		int time=1;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-->0) {
				current = queue.poll();
				int currentRi=current.ri;
				int currentRj=current.rj;
				int currentBi=current.bi;
				int currentBj=current.bj;
				
				for(int d=0;d<4;d++) {
					temp = new char[N][M];
					for(int i=0;i<N;i++) {
						for(int j=0;j<M;j++) {
							temp[i][j]=current.map[i][j];
						}
					}
					change(d,currentRi,currentRj,currentBi,currentBj);

					if(!blueEscape && redEscape) {
						System.out.println(time);
						return;
					}else if(blueEscape) {
						continue;
					}
					
					if(!visited[current.ri][current.rj][current.bi][current.bj]) {
						queue.offer(new status(d, temp, current.ri, current.rj, current.bi, current.bj));
						visited[current.ri][current.rj][current.bi][current.bj]=true;
					}
				}
			}
			time++;
			if(time>10) {
				System.out.println(-1);
				return;
			}
		}
		System.out.println(-1);
		

	}
	
	static void change(int d,int ri,int rj,int bi,int bj) {
		redEscape=false;
		blueEscape=false;
		
		if(d==0) {
			if(rj==bj) {
				if(ri>bi) {
					move(d,bi,bj,0);
					move(d,ri,rj,1);
				}else {
					move(d,ri,rj,1);
					move(d,bi,bj,0);
				}
			}else {
				move(d,bi,bj,0);
				move(d,ri,rj,1);
			}
		}else if(d==1) {
			if(rj==bj) {
				if(ri>bi) {
					move(d,ri,rj,1);
					move(d,bi,bj,0);
				}else {
					move(d,bi,bj,0);
					move(d,ri,rj,1);
				}
			}else {
				move(d,bi,bj,0);
				move(d,ri,rj,1);
			}
		}else if(d==2) {
			if(ri==bi) {
				if(rj>bj) {
					move(d,bi,bj,0);
					move(d,ri,rj,1);
				}else {
					move(d,ri,rj,1);
					move(d,bi,bj,0);
				}
			}else {
				move(d,bi,bj,0);
				move(d,ri,rj,1);
			}
		}else if(d==3) {
			if(ri==bi) {
				if(rj>bj) {
					move(d,ri,rj,1);
					move(d,bi,bj,0);
				}else {
					move(d,bi,bj,0);
					move(d,ri,rj,1);
				}
			}else {
				move(d,bi,bj,0);
				move(d,ri,rj,1);
			}
		}
	}
	
	static void move(int d,int nowi,int nowj,int color) {
		int nexti=nowi;
		int nextj=nowj;
		
		if(d==0) {
			
			for(int i=nowi-1;i>=0;i--) {
				if(temp[i][nowj]!='.') {
					if(temp[i][nowj]=='O') {
						if(color==0) {
							blueEscape=true;
						}else {
							redEscape=true;
						}
						temp[nowi][nowj]='.';
						return;
					}
					nexti=i+1;
					break;
				}
			}
		}else if(d==1) {
			for(int i=nowi+1;i<N;i++) {
				if(temp[i][nowj]!='.') {
					if(temp[i][nowj]=='O') {
						if(color==0) {
							blueEscape=true;
						}else {
							redEscape=true;
						}
						temp[nowi][nowj]='.';
						return;
					}
					nexti=i-1;
					break;
				}
			}
		}else if(d==2) {
			for(int j=nowj-1;j>=0;j--) {
				if(temp[nowi][j]!='.') {
					if(temp[nowi][j]=='O') {
						if(color==0) {
							blueEscape=true;
						}else {
							redEscape=true;
						}
						temp[nowi][nowj]='.';
						return;
					}
					nextj=j+1;
					break;
				}
			}
		}else if(d==3) {
			for(int j=nowj+1;j<M;j++) {
				if(temp[nowi][j]!='.') {
					if(temp[nowi][j]=='O') {
						if(color==0) {
							blueEscape=true;
						}else {
							redEscape=true;
						}
						temp[nowi][nowj]='.';
						return;
					}
					nextj=j-1;
					break;
				}
			}
		}
		
		//맵수정
		temp[nowi][nowj]='.';
		
		if(color==0) {
			current.bi=nexti;
			current.bj=nextj;
			temp[nexti][nextj]='B';
		}else {
			current.ri=nexti;
			current.rj=nextj;
			temp[nexti][nextj]='R';
		}
	}
	
	static class status{
		int d;
		char[][] map;
		int ri;
		int rj;
		int bi;
		int bj;
		public status(int d, char[][] map, int ri, int rj, int bi, int bj) {
			super();
			this.d = d;
			this.map = map;
			this.ri = ri;
			this.rj = rj;
			this.bi = bi;
			this.bj = bj;
		}
		
		
	}
	
	

}
