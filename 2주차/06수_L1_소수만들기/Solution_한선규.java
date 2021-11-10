public class P12977_소수만들기 {
        private final int r = 3; // 몇개뽑지?
        private int answer;

        public int solution(int[] nums) {
            int n = nums.length; // 숫자가 총 몇개지?

            comb(n, r, 0, 0, 0, nums);

            return answer;
        }

        public void comb(int n, int r, int start, int cnt, int sum, int[] nums) {

            if (cnt == r) { // r 개의 숫자를 다 뽑으면 종료
                answer += isPrime(sum) ? 1 : 0;
                return;
            }

            for (int i = start; i < n; i++) {
                sum += nums[i];
                comb(n, r, i + 1, cnt + 1, sum, nums);
                sum -= nums[i];
            }
        }

        public boolean isPrime(int num) {
            for (int i = 2; i < num; i++) {
                if (num % i == 0) return false;
            }
            return true;
        }
}
