import java.util.*;
class Solution {
    static boolean[] result;
    static int[] arr;
    static int N;
    static int decimal;

    public int solution(int[] nums) {
        
        N = nums.length;
        result = new boolean[N];
        arr = new int[N];
        arr = nums;
        decimal = 0;
        comb(0,0);
        return decimal;
    }
    
    public void comb(int target, int cnt){
        if(cnt == 3){
            int sum = 0;
            int check = 0;
            for(int i=0; i<result.length; i++){
                if(result[i]){
                    sum += arr[i];
                }
            }
            System.out.println(sum);
            for(int i=2; i<=sum/2; i++){
                if(sum%i==0){
                    check++;
                    break;
                }
            }
            if(check==0){
                decimal++;
            }
            return;
        }
        if(target == N){
            return;
        }
        result[target] = true;
        comb(target+1, cnt+1);
        result[target] = false;
        comb(target+1, cnt);
    }
}