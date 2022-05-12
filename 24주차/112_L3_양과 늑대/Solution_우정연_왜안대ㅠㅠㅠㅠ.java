// 인덱스가 두자리 수일 수 있음
// 로직이 틀린듯. 현재 그리디하게 하고있는데 그게 정답이라는 보장이 없음
import java.util.*;
class Solution {

    int sheep, wolf, nowSheep, nowWolf, N;
    int[] nowPath, path;
    int[] infoArr;
    LinkedList<Integer>[] edgeList;

    public int solution(int[] info, int[][] edges) {
        wolf = nowSheep = nowWolf = 0;
        sheep = 0;
        infoArr = info;
        N = infoArr.length;
        edgeList = new LinkedList[N];
        for(int i = 0 ; i < N ; i++) {
            edgeList[i] = new LinkedList<>();
        }
        for(int i = 0 ; i < edges.length ; i++) {
            edgeList[edges[i][0]].offer(edges[i][1]);
        }

        findSheep();

        return sheep;
    }
    void findSheep() {
        while(true) {
            nowSheep = 0;
            nowWolf = 0;
            path = new int[N];
            Arrays.fill(path, -2);
            dfs(0, sheep, wolf, 0);

            // 못가는 곳이였으면 false
            if(nowSheep == 0 && nowWolf == 0)
                return;
                // 갈 수 있었으면 양, 늑대 수 갱신
            else {
                sheep = nowSheep;
                wolf = nowWolf;
                for(int i = 0 ; i < N ; i++) {
                    if(nowPath[i] == -2) break;
                    infoArr[nowPath[i]] = -1;
                }
            }
        }
    }
    void dfs(int idx, int s, int w, int pathIdx) {
        s = infoArr[idx] == 0 ? s + 1 : s;
        w = infoArr[idx] == 1 ? w + 1 : w;
        path[pathIdx] = idx;

        if(s <= w) {
            path[pathIdx] = 0;  // 이거 안해줘서 틀리고
            return;
        }
        // 양/늑대가 아직 있고
        // 현재 양의 마리수가 이전보다 크고
        if(infoArr[idx] != -1 && sheep < s && (((nowSheep - nowWolf) < (s - w)) || (((nowSheep - nowWolf) == (s - w)) && nowSheep < s))) {
            nowSheep = s;
            nowWolf = w;
            nowPath = path.clone();
        }
        for(Integer next : edgeList[idx]) {
            dfs(next, s, w, pathIdx + 1);
        }
        path[pathIdx] = 0;
    }
}