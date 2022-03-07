import java.util.Arrays;

// 사람을 하나하나 분배해서 시간을 계산하는 방식으로는 답이 없다....
// 끝나는 시간을 기준으로 모든 심사관이 심사한 인원수를 더한 값이 총 인원수와 같다면 그만두자....
// 끝나는 시간이 나머지로 남은 경우 처리하지 추가로 처리할 수 없으므로 신경쓰지 않는다.
// 이분 탐색으로 시간을 탐색하자
// 처리한 인원수가 현재 인원보다 적다면 현재보다? 작업시간을 늘려야 한다.
// 처리한 인원수가 현재 인원보다 많다면 현재보다? 작업시간을 줄여야 한다.
// 
class Solution {
    public long solution(int n, int[] times) {
        int len = times.length;
        int[] t = new int[len];
        int maxtime = 0;
        for(int i = 0; i < len; i++){
            t[i] = times[i];
            maxtime = Math.max(maxtime, t[i]);
        }
                
        long min = 0;
        long max = (long) maxtime * n;
        long ans = 0;
        while(min <= max){
            long end = (min + max) / 2;
            long total = 0;
            
            for(int tt :t){
                total += end/tt;
            }
            
            if(total < n){
                min = end + 1;
            } else{
                max = end - 1;
                ans = end;
            }
        }
        
        return ans;
    }
}