package baekjoon;

public class PRO12903_가운데글자가져오기 {
    public String solution(String s) {
        int mid = (s.length() - 1) / 2;
        return s.length() % 2 == 0 ? s.substring(mid, mid + 2) : s.substring(mid, mid + 1);
    }
}
