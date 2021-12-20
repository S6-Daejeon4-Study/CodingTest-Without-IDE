import java.util.*;

class Solution {
    
    static StringBuilder sb;
    static char[] arr;
    static int M;
    static int N;
    static int[][] map;
    static boolean[][] visited2;
    static int[] di = {0,-1,1,0,0};
    static int[] dj = {0,0,0,-1,1};
    static boolean flag2;
    public String solution(int m, int n, String[] board) {
        String answer = "";
        int size=0;
        M=m;
        N=n;
        
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        arr = str.toCharArray();
        
        List<Integer> list = new ArrayList<>();
        
        
        map = new int[m][n];    //0-25 -> A-Z   빈칸30  벽 31
        for(int i=0;i<m;i++){
            String strr = board[i];
            for(int j=0;j<n;j++){
                char c = strr.charAt(j);
                if(c=='.'){
                    map[i][j]=30;
                    continue;
                }else if(c=='*'){
                    map[i][j]=31;
                    continue;
                }
                for(int k=0;k<26;k++){
                    if(c==arr[k]){
                        map[i][j]=k;
                        if(!list.contains(k)){
                             list.add(k);
                        }
                        size++;
                    }
                }
            }
        }
        Collections.sort(list);
        //입력 끝     
        
        boolean[] visited = new boolean[26];
        sb = new StringBuilder();
        
        boolean flag = false;
        size /=2;
        
        while(size-->0){
            flag = false;
            for(int i=0;i<list.size();i++){
                if(visited[list.get(i)]){
                    continue;
                }
                if(possible(list.get(i))){
                    delete(list.get(i));      //map에서 i는 빈칸으로 바꾸기
                    sb.append(list.get(i)+" ");   //나중에 알파벳으로
                    visited[list.get(i)] = true;
                    flag=true;
                    break;
                }
            }
            if(!flag){
                sb = new StringBuilder();
                sb.append("IMPOSSIBLE");
                break;
            }
        }
        
        if(flag){
            answer = change();   
        }else{
            answer = (sb+"");
        }
        
        return answer;
    }
    
    static boolean possible(int num){
        int nowi=0;
        int nowj=0;
        
        boolean flag3= false;
        
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(map[i][j]==num){
                    nowi=i;
                    nowj=j;
                    flag3=true;
                    break;
                }
            }
            if(flag3){
                break;
            }
        }
        
        visited2 = new boolean[M][N];
        flag2=false;
        dfs(nowi,nowj,num,0,0,0);
        return flag2;
        
    }
    
    static void dfs(int nowi,int nowj,int num,int cnt,int curD,int depth){
        if(flag2){
            return;
        }
         if(cnt>=3){
            return;
        }
        //if(num==4){
         //   System.out.println(nowi+" "+nowj);
        //}
        if(map[nowi][nowj]==num && depth!=0){
            //또 다른 나 찾음
            flag2=true;
            return;
        }
        visited2[nowi][nowj]= true;
        for(int d=1;d<5;d++){
            int nexti = nowi+di[d];
            int nextj = nowj+dj[d];
            
            if(nexti<0 || nextj<0 || nexti>=M || nextj>=N || visited2[nexti][nextj] || map[nexti][nextj]==31                   ){
                continue;
            }
            
            if(map[nexti][nextj]==30 || map[nexti][nextj]==num){
                if(d!=curD){
                    dfs(nexti,nextj,num,cnt+1,d,depth+1);
                    visited2[nexti][nextj]=false;
                 }else{
                    dfs(nexti,nextj,num,cnt,d,depth+1);
                    visited2[nexti][nextj]=false;
                }
            }
            
        }
    }
    
    static String change(){
        String str = (sb+"");
        sb= new StringBuilder();
        StringTokenizer st = new StringTokenizer(str);
        
        while(st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken());
            sb.append(arr[num]);
        }
        str=(sb+"");
        return str;
    }
    
    static void delete(int num){
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(map[i][j]==num){
                    map[i][j]=30;
                }
            }
        }
    }
        
}