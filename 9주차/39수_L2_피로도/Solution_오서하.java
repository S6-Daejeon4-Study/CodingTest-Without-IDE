class Solution {
    static int N,answer;
    static int[][] dungeon;
    static int[] arr;
    static boolean[] used;
    public int solution(int k, int[][] dungeons) {
        
        N = dungeons.length;

        arr = new int[N];
        used = new boolean[N];
        
        dungeon = dungeons;
        answer = Integer.MIN_VALUE;
        perm(0, k);
        return answer;
    }
    
    static void perm(int idx, int k){
        if(idx == N){
            int cnt = 0;
            for(int j = 0 ; j < N ; j++){
                if(k < dungeon[arr[j]][0]) break;
                k = k - dungeon[arr[j]][1];
                cnt++;
            }

            answer = cnt > answer ? cnt : answer;
            return;
        }
        
        for(int i = 0 ; i < N ; i++){
            if(used[i]) continue;
            used[i] = true;
            arr[idx] = i;
            perm(idx+1, k);
            used[i] = false;
        }
    }
    
    
    
    
}