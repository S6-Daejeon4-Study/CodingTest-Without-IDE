import java.util.*;
class Solution {
    ArrayList<Character> people = new ArrayList<>(Arrays.asList('A','C','F','J','M','N','R','T'));
    char[] orders = new char[8];
    int orderCnt;
    boolean[] selected;
    public int solution(int n, String[] data) {
        orderCnt=0;
       
        selected=new boolean[8];
        perm(0,data);
        
        return orderCnt;
    }
    public void perm (int cnt, String[] conditions){
        if(cnt==8){
            orderCnt++;
            return;
        }
        for(int i=0; i<8;i++){
            if(selected[i]) continue;
            selected[i]=true;
            orders[cnt]=people.get(i);
            if(isPossible(conditions,cnt)) perm(cnt+1,conditions);
            selected[i]=false;
        }
    }
    public boolean isPossible(String[] conditions,int cnt){

        for(String c : conditions){
            int orderP1=-1,orderP2=-1;
            for(int o=0; o<= cnt ; o++){
                if(orders[o]==c.charAt(0)) orderP1=o;
                if(orders[o]==c.charAt(2)) orderP2=o;
            }
            if(orderP1==-1||orderP2==-1) continue;
            int diff = Math.abs(orderP1-orderP2)-1;
            if(c.charAt(3)=='='&& diff!=(c.charAt(4)-'0')) return false;
            if(c.charAt(3)=='>'&& diff<=(c.charAt(4)-'0')) return false;
            if(c.charAt(3)=='<'&& diff>=(c.charAt(4)-'0')) return false;
        }
        return true;
    }
}