class Solution {
    public int solution(String s) {
        int answer = 10000;
        
        int size = s.length();
        int num=1;
        while(num<=size){
            int index=0;
            String check = s.substring(index,index+num);
            int count=1;
            index+=num;
            String temp2 = "";
            
            while(true){
                if(index+num>size){
                    if(count>1){
                        temp2 += count;   
                    }
                    temp2+=check;
                    temp2+=s.substring(index,size);
                    break;
                }
                String temp = s.substring(index,index+num);
                if(check.equals(temp)){
                    count++;
                }else{
                    if(count>1){
                        temp2 += count;   
                    }
                    temp2+=check;
                    check=temp;
                    count=1;
                }
                index+=num;
            }
            
            answer = Math.min(answer,temp2.length());   
            num++;
        }
          
        return answer;
    }
}