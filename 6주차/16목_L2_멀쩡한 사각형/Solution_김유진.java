class Solution {
    public long solution(int w, int h) {
        double tmp =- (double)h/(double)w;
        long answer = 0;
        for(int i = 1;i<w;i++)
            answer += (int)(  (double)h+tmp*(double)i);
        return answer*2;
    }
}