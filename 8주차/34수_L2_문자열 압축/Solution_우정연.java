
public class PRO60057_문자열압축 {
	class Solution {
		public int solution(String s) {
			int N = s.length();
			int answer = N;
			for (int l = 1; l <= N / 2; l++) {
				int len = 0;
				String lastS = "";
				String subS = "";
				int num = 1;
				for (int i = 0; i < N; i += l) {
					if (i + l > N) {
						len += N - i;
						break;
					}
					subS = s.substring(i, i + l);
					if (!lastS.equals(subS)) {
						if (num != 1)
							len += (num + "").length();
						len += l;
						lastS = subS;
						num = 1;
					} else {
						num++;
					}
				}
				if (num != 1)
					len += (num + "").length();
				answer = Math.min(answer, len);
			}
			return answer;
		}
	}
}
