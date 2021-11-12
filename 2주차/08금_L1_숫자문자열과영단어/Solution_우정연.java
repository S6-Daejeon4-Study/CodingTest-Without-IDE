import java.util.HashMap;
import java.util.Map;

public class PRO81301_숫자문자열과영단어 {
	String[] strToNum = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    public int solution(String s) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0 ; i < strToNum.length ; i++) {
            map.put(strToNum[i], i);
        }
        for(String key : map.keySet()) {
            s = s.replaceAll(key, map.get(key) + "");
        }
        int answer = Integer.parseInt(s);
        return answer;
    }
}
