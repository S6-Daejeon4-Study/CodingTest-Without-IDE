import java.util.*;

class Solution {
    static int[] result;
    static boolean[] isSelected;
    static String str;
    static List<Integer> calList;
    static Queue<Integer> calq;
    static List<Long> numbers;
    static long answer;
    public long solution(String expression) {
        answer = 0;
        
        //0 +, 1 -, 2 *
        str = expression;
        result = new int[3];
        isSelected = new boolean[3];
        calList = new ArrayList<>();
        
        for(int i=0;i<expression.length();i++){
            if(expression.charAt(i)=='+'){
                calList.add(0);
            }else if(expression.charAt(i)=='-'){
                calList.add(1);
            }else if(expression.charAt(i)=='*'){
                calList.add(2);
            }
        }

        perm(0);
        return answer;
    }
    
    static void perm(int cnt){
        if(cnt==3){
            String[] arr = str.split("\\+|-|\\*");
            numbers = new ArrayList<>();
            for(int i=0;i<arr.length;i++){
                numbers.add(Long.parseLong(arr[i]));
            }
            
            calq = new LinkedList<>();
            for(int i=0;i<calList.size();i++){
                calq.offer(calList.get(i));
            }
            
            cal(result[0]);
            cal(result[1]);
            cal(result[2]);
            
            answer = Math.max(answer, Math.abs(numbers.get(0)));
            return;
        }
        
        for(int i=0;i<3;i++){
            if(isSelected[i]){
                continue;
            }
            result[cnt]=i;
            isSelected[i]=true;
            perm(cnt+1);
            isSelected[i]=false;
        }
    }
    
    static void cal(int num){
        
        int time = calq.size();
        int index=0;
        while(time-->0){
            int what = calq.poll();
            if(what==num){
                if(num==0){
                    numbers.set(index,numbers.get(index)+numbers.get(index+1));
                }else if(num==1){
                    numbers.set(index,numbers.get(index)-numbers.get(index+1)); 
                }else if(num==2){
                    numbers.set(index,numbers.get(index)*numbers.get(index+1));
                }
                numbers.remove(index+1);
            }else{
                calq.offer(what);
                index++;
            }
        }
    }
}