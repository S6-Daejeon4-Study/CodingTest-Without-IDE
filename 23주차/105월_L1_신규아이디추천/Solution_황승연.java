class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        //1
        new_id = new_id.toLowerCase();
        String str = "";
        //2
        for(int i=0;i<new_id.length();i++){
            char c = new_id.charAt(i);
            if((c-'a'>=0 && c-'z'<=0) || (c-'0'>=0 && c-'0'<=9) ||c=='-'||c=='_'||c=='.'){
                str+=c+"";
            }
        }
        //3
        String temp="";
        if(str.length()>=1){
            
            for(int i=0;i<str.length();i++){
                char c = str.charAt(i);
                if(c=='.'){
                    int end = i+1;
                    while(end<str.length()){
                        if(str.charAt(end)!='.'){
                            break;
                        }
                        end++;
                    }

                    if(end!=str.length()){
                        i=end-1;
                    }else{
                        i=end;
                    }
                }
                temp+=c+"";
            }
        }
        
        //4
        if(temp.length()>=1){
            if(temp.charAt(0)=='.'){
                temp = temp.substring(1,temp.length());
            }
        }
        if(temp.length()>=1){
            if(temp.charAt(temp.length()-1)=='.'){
                temp = temp.substring(0,temp.length()-1);
            } 
        }
        //5
        if(temp.equals("")){
            temp+="a";
        }
        //6
        if(temp.length()>=16){
            temp = temp.substring(0,15);
            if(temp.charAt(temp.length()-1)=='.'){
                temp=temp.substring(0,14);
            }
        }
        //7
        if(temp.length()<=2 && temp.length()!=0){
            char c = temp.charAt(temp.length()-1);
            while(temp.length()<3){
                temp+=c+"";
            }
        }
        answer=temp;
        return answer;
    }
}