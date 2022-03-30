class Solution {
    public long[] solution(long[] numbers) {
        int length = numbers.length;
        long[] answer = new long[length];
        
        for(int i=0;i<length;i++)
            answer[i]=f(numbers[i]);
        
        return answer;
    }
    public long f(long x){
        if(x%2==0) return x+1;
        
        StringBuilder sb = new StringBuilder();
        
        while(x!=0){
            sb.append(x%2);
            x/=2;
        }
        sb.append(0);
        sb.reverse();
        
        int index = sb.lastIndexOf("01");
        sb.replace(index,index+2,"10");
        
        long dx=0;
        for(int i=0;i<sb.length();i++){
            dx += Math.pow(2,sb.length()-1-i)*(sb.charAt(i)-'0');
        }
        
        return dx;
    }
}