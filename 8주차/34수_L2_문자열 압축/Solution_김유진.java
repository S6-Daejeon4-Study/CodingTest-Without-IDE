import java.util.Stack;

class Solution {
    public int solution(String s) {
        Stack<Word> q = new Stack<>();
        
        int len = s.length();
        int answer = Integer.MAX_VALUE;

        // len이 1인 경우 len/2는 0이라서 조건식 추가함
        for(int i = 1; i<= ((len/2 == 0) ? 1 : len/2)  ; i++){ 
            for(int idx = 0; idx < len; idx += i){
                String tmp = s.substring(idx,(idx + i > len) ? len : idx + i);
                if(q.isEmpty() || !tmp.equals(q.peek().subWord))
                    q.push(new Word(tmp, 1));
                else
                    q.peek().cnt += 1;
            }

            int ans = 0;
            while(!q.isEmpty()){
                ans += q.pop().toString().length();
            }
            answer = Math.min(answer, ans);
        }

        return answer;
    }

    static class Word{
        String subWord;
        int cnt;
        
        public Word(String subWord, int cnt){
            this.subWord = subWord;
            this.cnt = cnt;
        }
        
        @Override
        public String toString(){
            if(this.cnt <= 1)
                return this.subWord;
            else
                return this.cnt + this.subWord;
        }
        
    }
}