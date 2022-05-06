import java.util.*;

class Solution {
    
    static boolean[] op; // 0 = * , 1 = -, 2 - + 
    static String[] opString = {"*", "-", "+"};
    static boolean[] visit;
    static int cnt;// 3가지 op가 몇개 나왔는가 확인하기 위함
    static ArrayList<String> list;
    static long answer;
    public long solution(String expression) {
        answer = 0;
     
        op = new boolean[3];
        visit = new boolean[3];
        list = new ArrayList<String>(); 
        
        int start = 0;
        for(int i = 0 ; i < expression.length() ; i++){
            if(expression.charAt(i) == '*' || 
               expression.charAt(i) == '-' || 
               expression.charAt(i) == '+' ){
                String num = expression.substring(start, i);
                start = i + 1;
                
                list.add(num);
                list.add(expression.charAt(i)+"");
                if(expression.charAt(i) == '*' && !op[0]){
                    op[0] = true;
                    cnt += 1;
                }
                else if(expression.charAt(i) == '-' && !op[1]){
                    op[1] = true;
                    cnt += 1;
                }
                else if(expression.charAt(i) == '+' && !op[2]){
                    op[2] = true;
                    cnt += 1;
                }
            } 
        }// 숫자와 연산자가 list에 각 인덱스에 나눠져서 들어가 있는 list, 3개 연산자 중 몇개 등장했는지 카운트 cnt
        
        list.add(expression.substring(start));
    
        perm(0, new String[cnt]);
        
        return answer;
    }
    
    public void perm(int idx, String[] order){
        if(idx == cnt){
            Long tempAns = cal(order);
            answer = Math.abs(tempAns) > answer ? Math.abs(tempAns) : answer;
            return;
        }
        
        for(int i = 0 ; i < 3 ; i++){
            //연산자가 이미 사용되었거나, 원문에서 나오지 않았다면
            if(visit[i] || !op[i]) continue;
            visit[i] = true;
            order[idx] = opString[i]; 
            perm(idx+1, order);
            visit[i] = false;
        }
    }
    
    public Long cal(String[] order){    
        ArrayList<String> tempList = new ArrayList<String>();
        Deque<String> queue = null;
        tempList.addAll(list);
        
        for(int idx = 0 ; idx < cnt ; idx++){
            queue = new ArrayDeque<String>();
            String opp = order[idx];
            
            for(int i = 0 ; i < tempList.size() ; i ++){
                if(tempList.get(i).equals(opp)){
                    String n1 = queue.pollLast();
                    i = i + 1;
                    String n2 = tempList.get(i);
                    Long res = compute(n1, n2, opp);
                    queue.add(res+"");
                }else
                    queue.add(tempList.get(i));
            }      
            tempList.clear();
            tempList.addAll(queue);
        }
        
        return Long.parseLong(queue.poll());
    }
    
    public Long compute(String n1, String n2, String opp){
        Long a = Long.parseLong(n1);
        Long b = Long.parseLong(n2);
        
        Long res = Long.valueOf(0);
        if(opp.equals(opString[0]))
            res = a * b;
        else if(opp.equals(opString[1]))
            res = a - b;
        else
            res = a + b;    
        return res;
    }
}
