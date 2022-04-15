import java.util.*;
class Solution {
    int[] dx = {0,1,1};
    int[] dy = {1,0,1};
    public int solution(int m, int n, String[] board) {
        char[][] map = new char[m][n];
        for(int i=0; i< m;i++)
            map[i]=board[i].toCharArray();
        
        while(findBlock(m,n,map))
            fall(m,n,map);
        
        return count(map);
    }
    public boolean findBlock(int m, int n, char[][] map){
        char[][] originMap=new char[m][n];
        
        for(int i=0; i< m;i++)
            for(int j=0; j< n;j++)
                originMap[i][j]=map[i][j];
            
        boolean isFound = false;
        for(int i=0; i< m-1;i++){
            block: for(int j=0; j< n-1;j++){
                char who = originMap[i][j];
                if(who=='.') continue;
                
                for(int d=0; d<3;d++)
                    if(originMap[i+dx[d]][j+dy[d]]!=who) continue block;
                
                map[i][j]='.';
                for(int d=0; d<3;d++)
                    map[i+dx[d]][j+dy[d]]='.';
                isFound=true;
            }
        }
        return isFound;
    }
    public void fall(int m, int n, char[][] map){
        int friends=0,blankCnt=0,start=-1;
        boolean blank=false;
        for(int j=0; j< n;j++){
            friends=0;
            blankCnt=0;
            start=-1;
            blank=false;
            for(int i=m-1; i>=0;i--){
                if(start==-1){
                    if(map[i][j]=='.') {
                        blankCnt++;
                        blank=true;
                    }   
                    else if(blank) {
                        start=i;
                        friends++;
                    }
                }
                else{
                    if(map[i][j]!='.') {
                        friends++;   
                        blank=false;
                    }
                    else {
                        down(friends,blankCnt,start, j, map);
                        start=-1;
                        friends=0;
                        blankCnt++;
                        blank=true;
                    }
                }
            }
            down(friends,blankCnt,start, j, map);
        }
    }
    public void down(int friends,int blankCnt,int startX, int y, char[][] map){
        for(int f=0;f<friends;f++){
            int x = startX-f;
            map[x+blankCnt][y]=map[x][y];
            map[x][y]='.';
        }
        
    }
    public int count(char[][] map){
        int cnt=0;
        for(char[] cArr : map)
            for(char c : cArr)
                if('.'==c) cnt++;
        return cnt;
    }
}