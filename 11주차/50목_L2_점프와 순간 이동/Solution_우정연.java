import java.util.*;

public class PRO12980_점프와순간이동{
    public int solution(int n) {
        int answer = 0;
        while(n > 0) {
            answer += n % 2;
            n /= 2;
        }
        return answer;
    }
    public int solution2(int n) {
        int[] memo = new int[n + 1];
        for(int i = 1 ; i <= n ; i++) {
            if(i % 2 == 1) {
                memo[i] = memo[i - 1] + 1;
            } else {
                memo[i] = Math.min(memo[i - 1] + 1, memo[i / 2]);
            }
        }
        
        return memo[n];
    }
     public int solution3(int n) {
        boolean[] visited = new boolean[n + 1];
        Queue<int[]> queue = new LinkedList<>();
        int answer = 0;
        queue.offer(new int[]{0, 0});
        while(!queue.isEmpty()) {
            int[] arr = queue.poll();
            if(arr[0] == n) {
                answer = arr[1];
                break;
            }
            if(arr[0] * 2 <= n && !visited[arr[0] * 2] && arr[0] * 2 != 0) {
                queue.offer(new int[]{arr[0] * 2, arr[1]});
                visited[arr[0] * 2] = true;
            }
            if(arr[0] + 1 <= n && !visited[arr[0] + 1]) {
                queue.offer(new int[]{arr[0] + 1, arr[1] + 1});
                visited[arr[0] + 1] = true;
            }
        }
        return answer;
    }
}