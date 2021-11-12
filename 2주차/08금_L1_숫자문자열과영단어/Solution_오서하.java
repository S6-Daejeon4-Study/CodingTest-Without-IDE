class Solution {
    String[] arr1 = {"zero","one","two","three","four","five","six","seven","eight","nine"};
    String[] num = {"0","1","2","3","4","5","6","7","8","9"};
    
    public int solution(String s) {
        String answer = "";
        String str = "";
        
        for(int i = 0 ; i < s.length() ;i++){
            String val = isNum(s.charAt(i)+"");
            
            if(val.equals("-1")){ // 숫자가 아님 즉 문자열임
                str+=s.charAt(i)+"";
                String val2 = isString(str);
                if( !val2.equals("-1")){
                    answer += val2;
                    str = "";
                }
            }
            else{
                answer += val;
            }
        }
        
        return Integer.parseInt(answer);
    }
    
    public String isNum(String s){
        for(int i = 0 ; i < arr1.length;i++){
            if(num[i].equals(s)){
                return num[i]; 
            }    
        }
        return "-1";
    }
    
    public String isString(String s){
        for(int i = 0 ; i < arr1.length;i++){
            if(arr1[i].equals(s)){
                return num[i]; 
            }    
        }
        return "-1";
    }
    
}