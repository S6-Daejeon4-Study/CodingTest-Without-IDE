class Solution {
    public String solution(int n) {
        int num = 1;
        while(n >= num * 3){
            num *= 3;
        }
        System.out.println("num init : " + num);
        int nn = n;
        String ans = "";
        while(num >= 1){
            if(num != 1 && nn - (nn / num) * num < num / 3){
                num /= 3;
                switch((nn / num - 1)){
                    case 1: 
                        ans += "1";
                        break;
                    case 2:
                        ans += "2";
                        break;
                    case 3:
                        ans += "4";
                        break;
                }
                nn -= (nn / num - 1) * num;
                 
            } else{
                switch(nn / num){
                    case 1: 
                        ans += "1";
                        nn -= num;
                        break;
                    case 2:
                        ans += "2";
                        nn -= num * 2;
                        break;
                    case 3:
                        ans += "4";
                        nn -= num * 3;
                        break;
                }
            }
            num /= 3;
        }
        
        
        
        return ans;
    }
}