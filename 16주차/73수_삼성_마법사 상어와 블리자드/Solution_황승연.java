package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_21611_마법사상어와블리자드 {

	static int[][] map;
	static int N;
	static int[] di = {0,-1,1,0,0};
	static int[] dj = {0,0,0,-1,1};
	static int[] rotateI = {0,1,0,-1};
	static int[] rotateJ = {-1,0,1,0};
	static List<Integer> list;
	static int sharkI;
	static int sharkJ;
	static int[] explosion;
	static boolean flag;
	static List<Integer> temp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		explosion = new int[4];
		
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		sharkI = (N-1)/2;
		sharkJ = (N-1)/2;
		
		while(M-->0) {
			st = new StringTokenizer(br.readLine());
			int d=Integer.parseInt(st.nextToken());
			int s=Integer.parseInt(st.nextToken());
			
			//1.파괴
			
			for(int i=1;i<=s;i++) {
				int nexti = sharkI+(di[d]*i);
				int nextj = sharkJ+(dj[d]*i);
				
				map[nexti][nextj]=0;
			}
			
			//2.회전하면서 리스트에 구슬 담기
			list = new ArrayList<>();
			rotate(0);
			
			//3.리스트 돌면서 연속구슬 찾고 폭발(더 이상 연속 없을 때까지)
			
			while(true) {
				flag=false;
				findContinue();
				if(!flag) {
					break;
				}
			}
			
			//4.구슬 변화
			temp = new ArrayList<>();
			change();
			
			//5.맵 새로 만들고 돌면서 temp에 있는 거 넣어주기
			map= new int[N][N];
			rotate(1);
		}
		
		System.out.println(explosion[1]+(2*explosion[2])+(3*explosion[3]));
	}
	
	static void change() {
		if(list.size()==0) {
			return;
		}
		int current = list.get(0);
		int cnt=1;
		
		if(list.size()==1) {
			temp.add(cnt);
			temp.add(current);
			return;
		}
		
		for(int i=1;i<list.size();i++) {
			current = list.get(i);
			
			if(current==list.get(i-1)) {
				cnt++;
			}else {
				int number = list.get(i-1);
				
				temp.add(cnt);
				temp.add(number);
				cnt=1;
			}
		}
		
		
		temp.add(cnt);
		temp.add(list.get(list.size()-1));			
	}
	
	static void findContinue() {
		if(list.size()<=1) {
			return;
		}
		int current = list.get(list.size()-1);
		int cnt=1;
		int start=list.size()-2;
		
		for(int i=start;i>=0;i--) {
			current = list.get(i);
			
			if(current==list.get(i+1)) {
				cnt++;
			}else {
				if(cnt>=4) {
					flag=true;
					int number = list.get(i+1);
					explosion[number]+=cnt;
					while(cnt-->0) {
						list.remove(i+1);
					}
				}
				cnt=1;
			}
		}
		
		if(cnt>=4) {
			flag=true;
			int number = list.get(0);
			explosion[number]+=cnt;
			while(cnt-->0) {
				list.remove(0);
			}
		}
	}
	
	//type 0이면 맵 돌면서 리스트에 넣기, 1이면 맵돌면서 템프에 있는 것 넣어주기
	static void rotate(int type) {
		
		int nowi = sharkI;
		int nowj = sharkJ;
		int d=0;
		int index=0;
		if(type==1 && temp.size()==0) {
			return;
		}
		for(int i=1;i<N;i++) {
			for(int j=0;j<2;j++) {
				int num=i;
				while(num-->0) {
					nowi = nowi+rotateI[d];
					nowj = nowj+rotateJ[d];
					
					if(type==0) {
						if(map[nowi][nowj]==0) {
							continue;
						}
						list.add(map[nowi][nowj]);						
					}else {
						map[nowi][nowj]=temp.get(index++);
						if(index>=temp.size()) {
							return;
						}
					}
				}
				d++;
				if(d>3) {
					d=0;
				}
			}
		}
		
		for(int i=1;i<N;i++) {
			nowi = nowi+rotateI[d];
			nowj = nowj+rotateJ[d];
			
			if(type==0) {
				if(map[nowi][nowj]==0) {
					continue;
				}
				list.add(map[nowi][nowj]);				
			}else {
				map[nowi][nowj]=temp.get(index++);
				if(index>=temp.size()) {
					return;
				}
			}
		}
	}

}
