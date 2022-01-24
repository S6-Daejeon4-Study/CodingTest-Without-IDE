import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        ArrayList<Integer>[] map = new ArrayList[n];
        
        for(int s=0;s<n;s++){
            map[s]=new ArrayList<Integer>();
        }
        for(int[] e : edge){
            int a= e[0]-1;
            int b= e[1]-1;
            map[a].add(b);
            map[b].add(a);
        }
        
        boolean[] visited = new boolean[n];
        int[] des = new int[n];
        Arrays.fill(des,20000*50001);
        des[0]=0;
        Queue<Integer> que = new LinkedList<>();
   
        int cnt=0;
        que.add(0);
        while(!que.isEmpty()){
            cnt++;
            int size = que.size();
            for(int s=0;s<size;s++){
                int start = que.poll(); 
                for(Integer d : map[start]){
                    if(!visited[d]) {
                        que.add(d);
                        des[d]=Math.min(des[d],cnt);
                        visited[d]=true;
                    }
                }
            }
        }
        
        int maxCnt=0,max=0;
         for(int a : des){
            if(a>20000*50001) continue;
            if(max<a) {
                maxCnt=0;
                max=a;
            }
            if(max==a) maxCnt++;
           
        }
        return maxCnt;
    }
}