import java.util.*;

class Solution {
    Map<String, Integer> hm;
    List<Character> list;
    char[] c;
    boolean[] check;
    
    public String[] solution(String[] orders, int[] course) {
        boolean[][] map = new boolean[orders.length][26];
        
        for(int i = 0; i < orders.length; i++) {
            for(int j = 0; j < orders[i].length(); j++) {
                char c = orders[i].charAt(j);
                map[i][c - 'A'] = true;
            }
            
        }
        
        hm = new HashMap<>();
        
        for (int i = 0; i < orders.length; i++) {
            list = new ArrayList<>();

            for (int k = 0; k < 26; k++) {
                if (map[i][k]) {
                    list.add((char) (k + 'A'));
                }
            }
            
            for(int len: course){
                if(list.size() >= len) {
                    c = new char[len];
                    check = new boolean[list.size()];
                    comb(0, 0);
                }
            }
            
        }
        
        String[] keys = hm.keySet().toArray(new String[0]);
        Arrays.sort(keys, new Comparator<String>(){
            
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        
        // System.out.println(Arrays.toString(keys));
        // System.out.println(hm.toString());
        
        Stack<String> stack = new Stack<>();
        // stack.push(keys[0]);
        
        for(int i = 0; i < keys.length; i++) {
            if(hm.get(keys[i]) < 2) 
               continue;
            if(stack.isEmpty()) {
                stack.push(keys[i]);
                continue;
            }
               
            // 메뉴 구성 개수가 같으면 비교
            if(stack.peek().length() == keys[i].length()) {
                if(hm.get(keys[i]) > hm.get(stack.peek())){ // 주문 수가 더 많으면
                    while(!stack.isEmpty() && stack.peek().length() == keys[i].length()){
                        stack.pop();
                    }
                    stack.push(keys[i]);
                }
                else if (hm.get(keys[i]) == hm.get(stack.peek())) // 주문 수가 같으면
                    stack.push(keys[i]);
                    
            } else {
                stack.push(keys[i]);
            }
        }
        
        String[] answer = stack.toArray(new String[0]);
        Arrays.sort(answer);
        
        return answer;
    }
    
    void comb(int idx, int start) {
        if(c.length == idx) {
            String s = "";
            for(int i = 0; i < c.length; i++) {
                s += c[i];
            }
            
            if (hm.containsKey(s)) {
                hm.put(s, hm.get(s) + 1);
            } else {
                hm.put(s, 1);
            }
            return;
        }
        
        for(int i = start; i < list.size(); i++){
            if(check[i]) continue;
            
            c[idx] = list.get(i);
            check[i] = true;
            comb(idx + 1, i + 1);
            check[i] = false;
        }
        
    }
    
}