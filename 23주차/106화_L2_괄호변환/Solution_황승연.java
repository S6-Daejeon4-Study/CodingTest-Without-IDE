class Solution {
    public String solution(String p) {
        String answer = "";
        
        answer= divide(p);
        
        return answer;
    }
    
    static String divide(String str){
        if(str.equals("")){
            return "";
        }
        
        int cnt=0;
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(c=='('){
                cnt++;
            }else{
                cnt--;
            }
            if(cnt==0){
                String u = str.substring(0,i+1);
                String v = str.substring(i+1,str.length());
                if(check(u)){
                    return u+divide(v);
                }else{
                    String temp = "(";
                    temp+=divide(v)+")";
                    u= u.substring(1,u.length()-1);
                    u=change(u);
                    temp+=u;
                    return temp;
                }
            }
        }
        
        return "";
    }
    
    static boolean check(String str){
        int cnt=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='('){
                cnt++;
            }else{
                cnt--;
            }
            if(cnt<0){
                return false;
            }
        }
        
        return true;
    }
    
    static String change(String str){
        String temp="";
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(c=='('){
                temp+=")";
            }else{
                temp+="(";
            }
        }
        return temp;
    }
}