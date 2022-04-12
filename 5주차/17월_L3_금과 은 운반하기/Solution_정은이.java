class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long answer = -1;
        long left = 0,right = (long)Math.pow(10,15); 
        while(left<=right){
            long mid = (left+right)/2;
            if(canCarry(mid,a,b,g,s,w,t)){
                answer=mid;
                right = mid-1;
            }else left=mid+1;
        }
        return answer;
    }
    public boolean canCarry(long time, int a, int b, int[] g, int[] s, int[] w, int[] t){
        long sum=0;
        long maxG=0, maxS=0;
        for(int i=0; i<g.length;i++){
            long cnt=0;
            if(time>=t[i]){
                cnt=1;
                cnt += (time-t[i])/(2*t[i]);
            }
            sum+=Math.min(g[i]+s[i],cnt* w[i]);
            maxG+=Math.min(g[i],cnt* w[i]);
            maxS+=Math.min(s[i],cnt* w[i]);
            
        }
        if(sum>=a+b && maxG>=a && maxS>=b) return true;
        return false;
    }
}