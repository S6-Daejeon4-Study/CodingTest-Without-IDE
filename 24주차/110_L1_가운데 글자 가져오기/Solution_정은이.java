class Solution {
    public String solution(String s) {
        int mid = s.length()/2;
        int mod = 1-s.length()%2;
        return s.substring(mid-mod,mid+1);
    }
}