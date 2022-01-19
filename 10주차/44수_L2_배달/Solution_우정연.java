import java.util.*;
public class PRO12978_¹è´Þ {
	class Solution {
	    final int INF = 1000000;
	    public int solution(int N, int[][] road, int K) {
	        int answer = 0;
	        int[][] edgeArr = new int[N][N];
	        for(int i = 0 ; i < road.length ; i++) {
	            int start = road[i][0] - 1;
	            int end = road[i][1] - 1;
	            int weight = road[i][2];
	            if(edgeArr[start][end] == 0 
	                    || (edgeArr[start][end] != 0 && edgeArr[start][end] > weight)) {
	                edgeArr[start][end] = weight;
	                edgeArr[end][start] = weight;
	            }
	        }
	        
	        answer = dijkstra(N, K, edgeArr);

	        return answer;
	    }
	    int dijkstra(int N, int K, int[][] edgeArr) {
	        boolean[] visited = new boolean[N];
	        int[] minDistArr = new int[N];
	        int minDist, minIdx;
	        int cnt = 0;
	        Arrays.fill(minDistArr, INF);
	        minDistArr[0] = 0;
	        
	        for(int n = 0 ; n < N ; n++) {
	            minDist = INF;
	            minIdx = -1;
	            for(int i = 0 ; i < N ; i++) {
	                if(!visited[i] && minDist > minDistArr[i]) {
	                    minDist = minDistArr[i];
	                    minIdx = i;
	                }
	            }
	            System.out.println(minIdx + " " + minDist);
	            if(minIdx == -1) break;
	            if(minDist > K) break;
	            visited[minIdx] = true;
	            cnt++;
	            
	            for(int j = 0 ; j < N ; j++) {
	                if(edgeArr[minIdx][j] == 0) continue;
	                int dist = edgeArr[minIdx][j];
	                if(!visited[j] && minDistArr[j] > minDist + dist) {
	                    minDistArr[j] = minDist + dist;
	                }
	            }
	                
	        }
	        return cnt;
	    }
	}
}
