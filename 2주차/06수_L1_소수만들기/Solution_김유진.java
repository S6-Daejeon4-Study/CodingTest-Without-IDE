import java.util.*;
class Solution {
    static boolean[] primechk= new boolean[3000];
    static int[] input;
    static int answer, len;
    public int solution(int[] nums) {
        input = nums;
        len = nums.length;
        for(int  i =2;i<(int)Math.sqrt(3000) + 1;i++){
            for(int j = 2; j*i < 3000; j++){
                primechk[j*i] = true;
            }
        }
        
        comb(0,0,0);
        
        return answer;
    }
    
    static void comb (int idx, int dep, int sum){
       
        
        if(dep == 3){
            if(!primechk[sum])
                answer++;
            return;
        }
        
        if(idx == len){
            return;
        }
   
        comb(idx+1,dep + 1, sum+input[idx]);
        comb(idx+1,dep, sum);

    }
}