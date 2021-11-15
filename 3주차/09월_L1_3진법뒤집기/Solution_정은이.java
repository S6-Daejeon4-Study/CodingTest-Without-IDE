class Solution {
    public int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        while(n/3>0){
            if(!(sb.length()==0&&n%3==0)) sb.append(String.valueOf(n%3));
            n/=3;
        }
        sb.append(String.valueOf(n%3));
        sb.reverse();
        for(int i=0;i<sb.length();i++){
            answer+=Math.pow(3,i)*(sb.charAt(i)-'0');
        }
        return answer;
    }
}