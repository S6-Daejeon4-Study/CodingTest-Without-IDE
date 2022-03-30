import java.util.*;
class Solution {
    public int solution(String name) {
        int length = name.length();
        StringBuilder left = new StringBuilder();
        StringBuilder right = new StringBuilder();
        int answer=0;
        for(int i=0; i<length;i++){
            int diff = name.charAt(i)-'A';
            int endDiff = 'Z'-name.charAt(i)+1;
            answer+=Math.min(diff,endDiff);
            left.append("A");
            right.append("A");
        }
        if(name.equals(left.toString())) return answer;
        left.replace(0,1,name.charAt(0)+"");
        if(name.equals(left.toString())) return answer+1;
        
        int moveCnt=1;
        Queue<Joy> que = new LinkedList<>();
        que.add(new Joy(left.toString(),1));
        que.add(new Joy(left.toString(),length-1));
        
        while(!que.isEmpty()){
            int size = que.size();
            for(int i=0;i<size;i++){
                Joy joy  = que.poll();
                String letter = joy.letter.substring(0,joy.idx)+name.charAt(joy.idx)+joy.letter.substring(joy.idx+1,length);
                if(name.equals(letter)) return answer+moveCnt;
                
                que.add(new Joy(letter,(joy.idx+1==length)?0:joy.idx+1));
                que.add(new Joy(letter,(joy.idx-1==-1)?length-1:joy.idx-1));
            }
            moveCnt++;
        }
        return answer+moveCnt;
    }
    class Joy{
        String letter;
        int idx;
        public Joy(String letter, int idx){
            this.letter=letter;
            this.idx=idx;
        }
    }
}