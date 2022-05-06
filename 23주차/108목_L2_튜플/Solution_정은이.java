import java.util.*;
class Solution {
    public int[] solution(String s) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) sb.append(c);
            else {
                if (sb.length() > 0) {
                    int tmp = Integer.parseInt(sb.toString());
                    map.put(tmp,map.getOrDefault(tmp,0)+1);
                }
                sb.delete(0, sb.length());
            }
        }
        for(Integer key : map.keySet()){
            pq.add(new Tuple(key,map.get(key)));
        }
        int[] answer = new int[map.size()];
        int i=0;
        while (!pq.isEmpty()) {
            Tuple t = pq.poll();
            answer[i++]= t.num;
        }
        return answer;
    }

    static class Tuple implements Comparable<Tuple> {
        int num, cnt;

        public Tuple(int num, int cnt) {
            this.num = num;
            this.cnt=cnt;
        }

        @Override
        public int compareTo(Tuple o) {
            return o.cnt - this.cnt;
        }
    }
}