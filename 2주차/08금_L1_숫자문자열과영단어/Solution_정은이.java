class Solution {
    public int solution(String s) {
        String[] numbers= {"zero","one","two","three","four","five","six","seven","eight","nine" };
        StringBuilder answer = new StringBuilder();
        StringBuilder num = new StringBuilder();

        for(int i=0; i<s.length();i++){
            if(s.charAt(i)-'0'>=0 && s.charAt(i)-'0'<10) answer.append(s.charAt(i));
            else{
                num.append(s.charAt(i));
                for(int j=0;j<10;j++){
                    if(num.toString().equals(numbers[j])){
                        answer.append(String.valueOf(j));
                        num.delete(0,num.length());
                    }
                }
            }
        }

        return  Integer.parseInt(answer.toString());
    }
}