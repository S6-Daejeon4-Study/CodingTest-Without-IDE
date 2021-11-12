import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        String[] arr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            //문자면 sb에추가하고 배열에 있는지 검사. 없으면 넘어가고 있으면 숫자로 바꿔서 result에 추가
            //숫자면 result에 추가
            if(c-'9'>0){    //문자면
                sb.append(c);
                for(int j=0;j<10;j++){
                       if((sb+"").contains(arr[j])){
                           result.append(j);
                           sb= new StringBuilder();
                           break;
                        }
                    }
            }else{
                result.append(c-'0');
            }
        }
        
        answer = Integer.parseInt(result+"");
        
        return answer;
    }
}