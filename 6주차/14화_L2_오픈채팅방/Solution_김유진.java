import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        int len = record.length;
        int cnt = 0;
        HashMap<String, String> map = new HashMap<>();
        String id = null;
        String nick = null;
        for(int i = 0; i<len;i++){
            StringTokenizer st = new StringTokenizer(record[i]);
            String action = st.nextToken();
            switch(action){
                case "Enter":
                    id = st.nextToken();
                    nick = st.nextToken();
                    map.put(id, nick);
                    cnt++;
                    break;
                case "Leave":
                    cnt++;
                    break;
                case "Change":
                    id = st.nextToken();
                    nick = st.nextToken();
                    map.put(id, nick);
                    break;
            }
            
        }
        String[] answer = new String[cnt];
        int idx = 0;
        for(int i = 0; i<len;i++){
            StringTokenizer st = new StringTokenizer(record[i]);
            String action = st.nextToken();
            switch(action){
                case "Enter":
                     id = st.nextToken();
                    answer[idx++] = map.get(id)+"님이 들어왔습니다.";
                    break;
                case "Leave":
                     id = st.nextToken();
                    answer[idx++] = map.get(id)+"님이 나갔습니다.";
                    cnt++;
                    break;
            }
        }
        return answer;
    }
}