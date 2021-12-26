import java.util.*;

class Solution {
    static int[] di ={-1,0,1,0};
    static int[] dj = {0,1,0,-1};
    static int n;
    static int m;
    static String[][] map;
    static List<Integer> list;
    static boolean[][][] memo;
    public List<Integer> solution(String[] grid) {
        
        n = grid.length;
        m = grid[0].length();
        map = new String[n][m];
        
        for(int i=0;i<n;i++){
            String str = grid[i];
            for(int j=0;j<m;j++){
                map[i][j] = str.substring(j,j+1);
            }
        }
        //입력 끝
        
        list = new ArrayList<>();
        memo = new boolean[n][m][4];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                for(int d=0;d<4;d++){
                    simul(i,j,d);
                }
            }
        }
        
        Collections.sort(list);
        
        return list;
    }
    
    static void simul(int si,int sj,int d){
        int nowi = si;
        int nowj = sj;
        
        int firstD = d;
        int distance = 0;
        
        while(true){
            if(memo[nowi][nowj][d]){
                break;
            }
            distance++;
            memo[nowi][nowj][d]=true;
            
            String what = map[nowi][nowj];

            if(what.equals("L")){
                d--;
                if(d<0){
                    d=3;
                }
            }else if(what.equals("R")){
                d++;
                if(d>3){
                    d=0;
                }
            }
            
            int nexti = nowi+di[d];
            int nextj = nowj+dj[d];
            
            if(nexti<0){
                nexti = n-1;
            }else if(nextj<0){
                nextj = m-1;
            }else if(nexti>=n){
                nexti=0;
            }else if(nextj>=m){
                nextj=0;
            }
            
            nowi= nexti;
            nowj = nextj;
        }
        if(distance!=0){
            list.add(distance);   
        }
    }
}