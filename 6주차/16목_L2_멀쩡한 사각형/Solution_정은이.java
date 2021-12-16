class Solution {
    public long solution1(int w, int h) {
       return (long)((long) w*h-(w+h)+getGcd(w,h));
    }
    public long solution2(int w, int h) {
        long answer = (long)w*h; 
        int gcd =getGcd(w,h);
        w/=gcd;
        h/=gcd;
        int cutArea = (w+h-1)*gcd;
        return (long)(answer-cutArea);
    
    }
    public long wrongSolution3(int w, int h) {
        // 오답 !!!!
        
        // long answer = (long)w*h;  // solution2와 비교
        long answer = (long)(w*h); // 여기가 중요 
        int gcd =getGcd(w,h);
        w/=gcd;
        h/=gcd;
        int cutArea = (w+h-1)*gcd;
        return (long)(answer-cutArea);
    }

    int getGcd(int a, int b){
        if(b==0){
            return a;
        }
        return getGcd(b,a%b);
    }
    
}