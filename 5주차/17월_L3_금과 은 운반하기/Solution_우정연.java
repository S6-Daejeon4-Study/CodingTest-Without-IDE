package programmers;
public class PRO86053_금과은운반하기 {
    class Solution {
        public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
            long ans = 0;
            long min = 0, max = 1000000000000000L;      // 가능한 최소 시간, 최대 시간
            int N = g.length;
            long aL = a, bL = b;
            while(min <= max) {                         // 파라메트릭 서치
                long sum = 0, gMax = 0, sMax = 0;       // 옮길 수 있는 합, 가능한 최대 금, 가능한 최대 은
                long mid = (min + max) / 2;
                for(int i = 0 ; i < N ; i++) {          // 모든 도시에 대해 검증
                    long cnt = 0;
                    long gold = g[i], silver = s[i], weight = w[i], time = t[i];
                    if(mid >= time) {                   // 한번 옮길 수 있으면 고고
                        cnt = 1;
                        cnt += (mid - time) / (2 * time);   // 그 이후 옮길 수 있는 횟수 구함
                    }

                    if(cnt * weight >= (gold + silver)) {   // 횟수동안 금, 은 전부 옮길 수 있다면
                        sum += gold + silver;
                        gMax += gold;
                        sMax += silver;
                    }
                    else {                                  // 일부만 옮길 수 있다면
                        sum += cnt * weight;
                        gMax += Math.min(gold, cnt * weight);
                        sMax += Math.min(silver, cnt * weight);
                    }
                }
                if((aL + bL) <= sum && aL <= gMax && bL <= sMax) {  // 필요한 금, 은을 모두 옮길 수 있다면 답이 될 수 있음!
                    ans = mid;
                    max = mid - 1;                    // 더 작은 값(시간) 구하러 범위 왼쪽으로 셋팅
                }
                else min = mid + 1;                   // 불가능하다면 시간이 더 필요하므로 범위 오른쪽으로 셋팅
            }
            return ans;
        }
    }
}
