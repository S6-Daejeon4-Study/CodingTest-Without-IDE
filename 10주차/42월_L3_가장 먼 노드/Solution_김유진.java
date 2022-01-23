import java.util.*;
class Solution {
    static ArrayList[] e;
    static boolean[] v;
    public int solution(int n, int[][] edge) {
        v = new boolean[n+1];
        e = new ArrayList[n+1];
        for(int i = 0; i <= n; i++){
            e[i] = new ArrayList<Integer>();
        }
        
        int len = edge.length;
        for(int i = 0; i < len; i++){
            int start = edge[i][0];
            int end = edge[i][1];
            e[start].add(end);
            e[end].add(start);
        }
        return bfs();
    }
    
    static int bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        v[1] = true;
        int cnt = 0;
        while(!q.isEmpty()){
            cnt = q.size();
            //System.out.println(cnt);
            for(int i = 0; i < cnt; i++){
                int tmp = q.poll();
                // System.out.println(tmp);
                int len = e[tmp].size();
                for(int j = 0; j < len; j++){
                    int n = (int) e[tmp].get(j);
                    if(!v[n]){
                        // System.out.print(n + " ");
                        q.offer(n);
                        v[n] = true;
                    }   
                }
            }
        }
        return cnt;
    }
}