import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int[] di = {0,-1,1,0,0};
	static int[] dj = {0,0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] sharkMap = new int[N][N];
		Smell[][] smellMap = new Smell[N][N];
		Shark[] sharkList = new Shark[M+1];
		int[][][] sharkDirection = new int[M+1][5][5];
		
		for(int i=0;i<N;i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				sharkMap[i][j] = Integer.parseInt(st.nextToken());
				if(sharkMap[i][j] !=0) {
					sharkList[sharkMap[i][j]] = new Shark(sharkMap[i][j], i, j, 0);
					smellMap[i][j] = new Smell(sharkMap[i][j], k);
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=M;i++) {
			sharkList[i].d=Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<=M;i++) {
			for(int j=1;j<=4;j++) {
				st= new StringTokenizer(br.readLine());
				for(int d=1;d<=4;d++) {
					sharkDirection[i][j][d] = Integer.parseInt(st.nextToken());
				}
			}
		}
		//입력 끝
		
		int time=0;
		
		while(true) {
			time++;
			for(int i=1;i<=M;i++) {		//i는 상어번호
				if(sharkList[i]==null) {
					continue;
				}
				
				Shark s = sharkList[i];
				int num=0;
				List<Integer> noSmellList = new ArrayList<>();
				List<Integer> mySmellList = new ArrayList<>();
				
				for(int d=1;d<=4;d++) {
					int nexti = s.i+di[d];
					int nextj = s.j+dj[d];
					
					if(nexti<0 || nextj<0 || nexti>=N || nextj>=N) {
						continue;
					}
					
					if(smellMap[nexti][nextj]==null) {
						num++;
						noSmellList.add(d);
					}else if(smellMap[nexti][nextj].sharkNum ==i) {
						mySmellList.add(d);
					}
				}
				
				if(num>1) {
					for(int d=1;d<=4;d++) {
						if(noSmellList.contains(sharkDirection[i][s.d][d])) {
							s.d=sharkDirection[i][s.d][d];
							break;
						}
					}
				}else if(num==1) {
					s.d=noSmellList.get(0);
				}else {
					for(int d=1;d<=4;d++) {
						if(mySmellList.contains(sharkDirection[i][s.d][d])) {
							s.d=sharkDirection[i][s.d][d];
							break;
						}
					}
				}
				//바뀐 방향으로 이동
				s.i = s.i+di[s.d];
				s.j = s.j+dj[s.d];
				
			}
			
			sharkMap = new int[N][N];
			for(int i=1;i<=M;i++) {
				if(sharkList[i]==null) {
					continue;
				}
				Shark s = sharkList[i];
				
				if(sharkMap[s.i][s.j]==0) {
					sharkMap[s.i][s.j] = s.sharkNum;
				}else {
					sharkList[i]=null;
				}
			}

			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(smellMap[i][j]!=null) {
						smellMap[i][j].restTime-=1; 
						if(smellMap[i][j].restTime==0) {
							smellMap[i][j]=null;
						}
					}
				}
			}
			
			for(int i=1;i<=M;i++) {
				if(sharkList[i]==null) {
					continue;
				}
				Shark s = sharkList[i];
				
				smellMap[s.i][s.j] = new Smell(s.sharkNum, k);
			}
			
			//1만 남았는지 체크
			boolean flag = false;
			for(int i=2;i<=M;i++) {
				if(sharkList[i]!=null) {
					flag=true;
					break;
				}
			}
			
			if(time>1000) {
				System.out.println(-1);
				return;
			}
			if(!flag) {
				System.out.println(time);
				return;
			}
			
		}	
	}
	
	static class Shark{
		int sharkNum;
		int i;
		int j;
		int d;
		public Shark(int sharkNum, int i, int j, int d) {
			super();
			this.sharkNum = sharkNum;
			this.i = i;
			this.j = j;
			this.d = d;
		}
		
	}
	
	static class Smell{
		int sharkNum;
		int restTime;
		public Smell(int sharkNum, int restTime) {
			super();
			this.sharkNum = sharkNum;
			this.restTime = restTime;
		}
		
	}

}