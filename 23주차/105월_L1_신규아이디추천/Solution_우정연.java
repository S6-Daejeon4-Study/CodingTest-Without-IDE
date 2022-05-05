package programmers;


public class PRO72410_신규아이디추천_재 {
    public String solution(String new_id) {
        String s = new_id.toLowerCase().replaceAll("[^0-9a-z-._]?", "").replaceAll("[.]+",".").replaceAll("(^\\.)?(\\.$)?", "");
        if(s.length() == 0) s = "a";
        if(s.length() >= 16) s = s.substring(0, 15).replaceAll("(\\.$)?", "");
        while(s.length() < 3) {
            s += s.charAt(s.length() - 1);
        }

        return s;
    }
}
