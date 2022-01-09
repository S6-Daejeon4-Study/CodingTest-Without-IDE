import java.util.*;

class Solution {
    static int answer, num;
    static char[] member = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static char[][] c;
    public int solution(int n, String[] data) {
        c = new char[n][4]; // 조건 저장용
        num = n;
        answer = 0;
        for(int i = 0; i < n; i++){
            char[] tmp = data[i].toCharArray();
            c[i][0] = tmp[0]; // 당사자
            c[i][1] = tmp[2]; // 상대방
            c[i][2] = tmp[3]; // "=", "<", ">"
            c[i][3] = tmp[4]; // 거리
            //System.out.println(c[i][0] + c[i][1] + c[i][2] + c[i][3]);
        }
        dfs("");
        return answer;
    }
    
    static void dfs(String memberSet){
        if(memberSet.length() == 8){
            HashMap<Character, Integer> map = new HashMap<>();
            for(int i = 0; i < 8; i++){
                map.put(memberSet.charAt(i),i); // <프렌즈, 위치>
            }
            
            for(int i = 0; i < num; i++){
                switch(c[i][2]){
                    case '=': 
                        if(Math.abs(map.get(c[i][0])-map.get(c[i][1])) - 1 != c[i][3]-'0')
                           return; // 위치가 같지 않으면 return
                        break;
                    case '<':
                        if(Math.abs(map.get(c[i][0])-map.get(c[i][1])) - 1 >= c[i][3]-'0')
                           return; // 거리보다 크거나 같으면 return
                        break;
                    case '>':
                        if(Math.abs(map.get(c[i][0])-map.get(c[i][1])) - 1 <= c[i][3]-'0')
                           return; // 거리보다 작거나 같으면 return
                        break;
                }
            }
            
            answer++;  
            return;
        }
        
        for(int i = 0; i < 8;i++){
            if(!memberSet.contains(member[i]+""))
                dfs(memberSet + member[i]);
        }
    }
}