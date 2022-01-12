

public class PRO87946_ÇÇ·Îµµ {
	class Solution {
	    int answer;
	    boolean[] visited;
	    public int solution(int k, int[][] dungeons) {
	        answer = 0;
	        visited = new boolean[dungeons.length];
	        perm(dungeons, 0, k, 0);
	        return answer;
	    }
	    
	    void perm(int[][] dungeons, int idx, int tired_degree, int cnt) {
	        if(idx == dungeons.length) {
	            answer = Math.max(answer, cnt);
	            return;
	        }
	        for(int i = 0 ; i < dungeons.length ; i++) {
	            if(visited[i]) continue;
	            visited[i] = true;
	            if(tired_degree >= dungeons[i][0]) 
	                perm(dungeons, idx + 1, tired_degree - dungeons[i][1], cnt + 1);
	            else perm(dungeons, idx + 1, tired_degree, cnt);
	            visited[i] = false;
	        }
	    }
	}
}
