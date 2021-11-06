class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        int len = absolutes.length;

        for (int i = 0; i < len; i++) {
            answer += (signs[i] ? absolutes[i] : absolutes[i] * -1);
        }

        return answer;
    }
}