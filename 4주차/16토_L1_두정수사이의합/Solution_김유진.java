class Solution {
    public long solution(int a, int b) {
        if (a==b)
            return a;
        int minNum = Math.min(a,b);
        int maxNum = Math.max(a,b);
        
        long answer = (long)(maxNum - minNum+1)*(maxNum + minNum)/2;
        return answer;
    }
}