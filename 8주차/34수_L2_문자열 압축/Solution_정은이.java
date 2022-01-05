class Solution {
    public int solution(String s) {
        int length = s.length();
        int answer = length;
        for(int i=1; i<length;i++){
            StringBuilder sb = new StringBuilder();
            String previous = s.substring(0,i);
            int cnt=1;
            String current=null;
            for(int j=i; j<length;j+=i){
                if(j+i>=length) {
                    current=s.substring(j,length);
                    if(previous.equals(current)) cnt++;
                    if(cnt!=1) {
                        sb.append(String.valueOf(cnt));
                    }
                    sb.append(previous);
                    if(!previous.equals(current)) sb.append(current);
                    continue;
                }
               else{
                    current = s.substring(j,j+i);
                }
                if(previous.equals(current)) cnt++;
                else{
                    if(cnt!=1) sb.append(String.valueOf(cnt));
                    sb.append(previous);
                    previous=current;
                    cnt=1;
                }
            }
            answer=Math.min(answer,sb.length());
        }
        return answer;
    }
}