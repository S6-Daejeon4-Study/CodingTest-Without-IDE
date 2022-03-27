package programmers;

import java.util.Arrays;

// weak에 대해 순열(최대 dist 길이만큼)
// 매번 visited 다 되어있는지 체크
// 왜 시간초과 나는지 몰랐는데 순열이라고 써놓고 조합으로 시간계산 하고 있었네ㅋㅋㅋㅋㅋ
public class PRO60062 {
    int weakN, distN, N, ans;
    int[] newDist, newWeak;
    public int solution(int n, int[] weak, int[] dist) {
        ans = Integer.MAX_VALUE;
        N = n;
        weakN = weak.length;
        distN = dist.length;
        newWeak = weak;
        boolean[] visited = new boolean[weakN];
        Arrays.sort(dist);
        newDist = new int[distN];
        for(int i = 0 ; i < distN ; i++) {
            newDist[distN - i - 1] = dist[i];
        }

        perm(0, visited);

        if(ans == Integer.MAX_VALUE) ans = -1;
        return ans;
    }

    public void perm(int idx, boolean[] visited) {
        if(idx >= ans) return;
        boolean result = true;
        for(int i = 0 ; i < weakN ; i++) {
            result &= visited[i];
        }
        if(result) {
            ans = Math.min(ans, idx);
            return;
        }
        if(idx >= distN || idx >= weakN) return;
        for(int i = 0 ; i < weakN ; i++) {
            if(visited[i]) continue;
            // 시계방향으로 검사
            boolean[] newVisited = visited.clone();
            int start = newWeak[i], end = newWeak[i] + newDist[idx];
            for(int j = 0 ; j < weakN ; j++) {
                int now = newWeak[j] < start ? newWeak[j] + N : newWeak[j];
                if(start <= now && now <= end) newVisited[j] = true;
            }
            perm(idx + 1, newVisited);

            // 반시계방향으로 검사
            newVisited = visited.clone();
            start = newWeak[i] + N - newDist[idx]; end = newWeak[i] + N;
            for(int j = 0 ; j < weakN ; j++) {
                int now = newWeak[j] >= start ? newWeak[j] + N : newWeak[j];
                if(start <= now && now <= end) newVisited[j] = true;
            }
            perm(idx + 1, newVisited);
        }
    }
}
