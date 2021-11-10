import java.util.*;

class Solution {
    static int N;
    static int answer;
    public int solution(int[] nums) {
        answer = 0;
        
        N = nums.length;
       
        comb(0,0,nums,0);
        return answer;
    }
    
    static void comb(int cnt,int target,int[] arr,int sum){
        if(cnt==3){
             boolean flag = false;
            for(int i=2;i<sum;i++){
                if(sum%i==0){
                    flag=true;
                    break;
                }
            }
            if(!flag){
                answer++;
            }
            
            return;
        }
        if(target==N){
            return;
        }
        
       comb(cnt+1,target+1,arr,sum+arr[target]);
       comb(cnt,target+1,arr,sum);
    }
}