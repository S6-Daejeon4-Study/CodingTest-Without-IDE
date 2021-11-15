class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String reverse = "";
        while(n > 0){
            int val = n % 3 ;
            n = n / 3;
            reverse += val + "";
        }
        
        for(int i = 0 ; i < reverse.length()  ; i++){
           int val = Integer.parseInt(reverse.charAt(i)+"");
            int j = (reverse.length()-1) - i ;
            answer += (val)*Math.pow(3,j);
        }
        return answer;
    }
}