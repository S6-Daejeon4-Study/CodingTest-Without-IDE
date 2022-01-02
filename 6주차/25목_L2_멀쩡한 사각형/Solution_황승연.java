class Solution {
    public long solution(int w, int h) {
        long answer = 0;
        
        int max = Math.max(w,h);
        int min = Math.min(w,h);
        
        int num=1;
        
        for(int i=min;i>0;i--){
            if(max%i==0 && min%i==0){
                num=i;
                break;
            }
        }
        
        answer = (long)w*h-(w+h-num);
        
        return answer;
    }
}