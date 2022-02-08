import java.util.*;

class Solution {
    static int[] arr = {1,2,4};
    static int[] result;
    static StringBuilder sb;
    static int index;
    public String solution(int n) {
        String answer = "";
        
        int num=1;      //자리수
        int sum=0;
        while(true){
            sum += Math.pow(3,num);
            if(n<=sum){
                break;
            }
            num++;
        }
        
        index = sum-(int)(Math.pow(3,num));        //3
        
        result = new int[num];
       
        for(int i=num;i>0;i--){
            int number =(int)Math.pow(3,i-1); 
            if(index+number>=n){
                result[num-i]=1;
            }else if(index+(number*2)>=n){
                result[num-i]=2;
                 index +=number;
            }else if(index+(number*3)>=n){
                result[num-i]=4;
                index +=(number*2);
            }
           
        }
        
        sb= new StringBuilder();
        
        for(int i=0;i<num;i++){
            sb.append(result[i]);
        }
        
        answer = answer+sb;
        
        return answer;
    }
    
    
}