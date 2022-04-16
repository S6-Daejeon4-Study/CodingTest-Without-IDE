import java.util.*;

class Solution {
    
    static char[][] map;
    static int M;
    static int N;
    static int[] di ={0,1,1};   //오른쪽, 아래, 오른쪽아래
    static int[] dj ={1,0,1};
    static boolean[][] boom;
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        map = new char[m][n];
        M = m;
        N = n;
        
        for(int i=0;i<m;i++){
            String str = board[i];
            for(int j=0;j<n;j++){
                map[i][j] = str.charAt(j);
            }
        }
        //입력 끝
        
        while(true){
            boolean flag=false;             //터질게 있는지
            boom = new boolean[m][n];
        
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(map[i][j] !='b'){
                        if(check(i,j)){         //2X2인지 확인
                            flag=true;
                            boomList(i,j);      //맞으면 boom배열에 true처리
                        }   
                    }
                }
            }
        
            if(!flag){
                break;
            }
        
            //boom에 있는 애들 개수 세주고 비우기
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(boom[i][j]){
                        answer++;
                        map[i][j]='b';      //비었다는 뜻
                    }
                }
            }
            //아래로 땡기기
            Stack<Character> stack = new Stack<>();

            for(int j=0;j<n;j++){
                stack.clear();
                for(int i=0;i<m;i++){
                    if(map[i][j]!='b'){
                        stack.add(map[i][j]);
                    }
                }

                for(int i=m-1;i>=0;i--){
                    if(!stack.isEmpty()){
                        map[i][j] = stack.pop();
                    }else{
                        map[i][j]='b';
                    }
                }
            }
        }   
            
        return answer;
    }
    
    static boolean check(int nowi,int nowj){
        char friend = map[nowi][nowj];
        boolean flag = true;
        for(int d=0;d<3;d++){
            int nexti = nowi+di[d];
            int nextj = nowj+dj[d];
            
            if(nexti<0 || nextj<0 || nexti>=M || nextj>=N || map[nexti][nextj] !=friend){
                flag=false;
                break;
            }
        }
        
        return flag;
    }
    
    static void boomList(int nowi,int nowj){
        boom[nowi][nowj] = true;
        for(int d=0;d<3;d++){
            int nexti = nowi+di[d];
            int nextj = nowj+dj[d];
            
            boom[nexti][nextj] = true;
        }
    }
    
}