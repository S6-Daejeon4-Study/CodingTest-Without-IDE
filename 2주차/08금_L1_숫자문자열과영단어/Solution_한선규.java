import java.util.HashMap;
import java.util.Map;

public class P81301_숫자문자열과영단어 {
    public int solution(String s) {
        int answer = 0;
        Map<String, String> map = new HashMap<>(10);
        String[] strToNum = {
                "zero",
                "one",
                "two",
                "three",
                "four",
                "five",
                "six",
                "seven",
                "eight",
                "nine"
        };

        for (int i = 0; i < strToNum.length; i++) {
            map.put(strToNum[i], i+"");
        }

        // map.forEach((key, value) -> { // 람다식에서 참조하는 외부 지역 변수는 final 혹은 effectively final 이어야 함
        //     s = s.replace(key, value);
        // });

        for (Map.Entry<String, String> entry : map.entrySet()) {
            s = s.replace(entry.getKey(), entry.getValue());
        }

        answer = Integer.parseInt(s);

        return answer;
    }
}
