class Solution {
    public String solution(String[] names) {
        for (int i = 0; i < names.length; i++) {
            if (names[i].equalsIgnoreCase("kim")) {
                return "김서방은 " + i + "에 있다";
            }
        }
        return null;
    }
}