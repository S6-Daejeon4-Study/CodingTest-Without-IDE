import java.util.Queue;
import java.util.LinkedList;
class Solution {
    static Queue<Doc> q;
    static int[] impo;
    public int solution(int[] priorities, int location) {
        int len = priorities.length;
        q=new LinkedList<Doc>();
        impo = new int[10];
        for(int i = 0; i < len; i++){
            q.add(new Doc(i,priorities[i]));
            impo[priorities[i]]++;
        }
        Doc tmp = null;
        int cnt = 0;
        while(!q.isEmpty()){
            tmp = q.poll();
            boolean chk =true;
            for(int  i = 9;i>tmp.impo;i--){
                if(impo[i] != 0){
                    chk = false;
                    q.add(tmp);
                    break;
                }
            }
            if(chk ){
                cnt++;
                impo[tmp.impo]--;
                if(tmp.idx == location)
                    break;
            }
        }
        return cnt;
    }
    static class Doc{
        int idx, impo;
        public Doc(int idx, int impo){
            this.idx = idx;
            this.impo = impo;
        }
    }
}