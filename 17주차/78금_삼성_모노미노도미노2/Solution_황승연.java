package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_20061_모노미노도미노2 {

	static boolean[][] blue;
	static boolean[][] green;
	static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		blue = new boolean[4][6];
		green = new boolean[6][4];
		answer=0;
		
		while(N-->0) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());	//블록 타입 1,2,3
			int x = Integer.parseInt(st.nextToken());	//행
			int y = Integer.parseInt(st.nextToken());	//열
			
			move(t,x,y);
			check();
			
			int count=check2Green();
			if(count>0) {
				removeAndMoveGreen(count);				
			}
			count = check2Blue();
			if(count>0) {
				removeAndMoveBlue(count);				
			}
		}
		
		int answer2=0;
		for(int i=0;i<6;i++) {
			for(int j=0;j<4;j++) {
				if(green[i][j]) {
					answer2++;
				}
				if(blue[j][i]) {
					answer2++;
				}
			}
		}
		
		System.out.println(answer);
		System.out.println(answer2);

	}
	
	static void removeAndMoveBlue(int count) {
		int index=5;
		int cnt = count;
		
		while(cnt-->0) {
			for(int i=0;i<4;i++) {
				blue[i][index]=false;
			}
			index--;
		}
		
		for(int i=0;i<4;i++) {
			for(int k=index;k>=0;k--) {
				if(blue[i][k]) {
					blue[i][k]=false;
					blue[i][k+count]=true;
				}
			}
			
		}
	}
	
	static void removeAndMoveGreen(int count) {
		int index=5;
		int cnt = count;
		
		while(cnt-->0) {
			for(int j=0;j<4;j++) {
				green[index][j]=false;
			}
			index--;
		}
		
		for(int j=0;j<4;j++) {
			for(int k=index;k>=0;k--) {
				if(green[k][j]) {
					green[k][j]=false;
					green[k+count][j]=true;
				}
			}
			
		}
	}
	
	
	static int check2Green() {
		int sum=0;
		for(int i=0;i<2;i++) {
			int num=0;
			for(int j=0;j<4;j++) {
				if(green[i][j]) {
					num=1;
					break;
				}
			}
			sum+=num;
		}
		
		return sum;
	}
	
	static int check2Blue() {
		int sum=0;
		for(int j=0;j<2;j++) {
			int num=0;
			for(int i=0;i<4;i++) {
				if(blue[i][j]) {
					num=1;
					break;
				}
			}
			sum+=num;
		}
		
		return sum;
	}
	
	static void check() {
		//그린
		for(int i=2;i<6;i++) {
			boolean flag =true;		//모든 칸 타일인지
			for(int j=0;j<4;j++) {
				if(!green[i][j]) {
					flag=false;
					break;
				}
			}
			if(!flag) {		//모든칸 타일아니면 다음행보기
				continue;
			}
		
			for(int j=0;j<4;j++) {
				green[i][j]=false;
			}
			answer++;
			
			
			//땡겨오기
			for(int j=0;j<4;j++) {
				for(int k=i-1;k>=0;k--) {
					if(green[k][j]) {
						green[k][j]=false;
						green[k+1][j]=true;
					}
				}
			}
			
		}
		
		//블루
		for(int j=2;j<6;j++) {
			boolean flag =true;		//모든 칸 타일인지
			for(int i=0;i<4;i++) {
				if(!blue[i][j]) {
					flag=false;
					break;
				}
			}
			
			if(!flag) {		//모든칸 타일아니면 다음열보기
				continue;
			}
			
			for(int i=0;i<4;i++) {
				blue[i][j]=false;
			}
			answer++;
			
			//땡겨오기
			for(int i=0;i<4;i++) {
				for(int k=j-1;k>=0;k--) {
					if(blue[i][k]) {
						blue[i][k]=false;
						blue[i][k+1]=true;
					}
				}
			}
			
		}
	}
	
	static void move(int t,int x,int y) {
		int index;
		if(t==1) {
			index=5;		//그린
			for(int i=0;i<6;i++) {
				if(green[i][y]) {
					index=i-1;
					break;
				}
			}
			green[index][y]=true;
			
			index=5;		//블루
			for(int j=0;j<6;j++) {
				if(blue[x][j]) {
					index=j-1;
					break;
				}
			}
			blue[x][index]=true;
			
		}else if(t==2) {
			index=5;
			for(int i=0;i<6;i++) {
				if(green[i][y] || green[i][y+1]) {
					index=i-1;
					break;
				}
			}
			green[index][y]=true;
			green[index][y+1]=true;
			
			index=5;
			for(int j=0;j<6;j++) {
				if(blue[x][j]) {
					index=j-1;
					break;
				}
			}
			blue[x][index]=true;
			blue[x][index-1]=true;
		}else if(t==3) {
			index = 5;
			for(int i=0;i<6;i++) {
				if(green[i][y]) {
					index=i-1;
					break;
				}
			}
			green[index][y]=true;
			green[index-1][y]=true;
			
			index=5;
			for(int j=0;j<6;j++) {
				if(blue[x][j] || blue[x+1][j]) {
					index=j-1;
					break;
				}
			}
			blue[x][index]=true;
			blue[x+1][index]=true;
		}
	}

}
