class Solution {
    int[] order;
    boolean[] selected;
    int N,answer;
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        N=dungeons.length;
        order = new int[N];
        selected = new boolean[N];
        perm(k,0,dungeons);
        
        return answer;
    }
    public void perm(int k, int idx,int[][] dungeons){
        if(N==idx) {
            int cnt=0;
            int k2=k;
            for(int i=0;i<N;i++){
                if(k2>=dungeons[order[i]][0]){
                    k2-=dungeons[order[i]][1];
                    cnt++;
                }
            }
            answer = Math.max(answer,cnt);
            return;
        }
        for(int i=0;i<N;i++){
            if(selected[i]) continue;
            selected[i]=true;
            order[idx]=i;
            perm(k,idx+1,dungeons);
            selected[i]=false;
        }
    }
}