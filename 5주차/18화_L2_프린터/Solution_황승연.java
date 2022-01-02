import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int size = priorities.length;
        int max = 0;
        int[] important = new int[10];
        LinkedList<print> list = new LinkedList<>();
        
        for(int i=0;i<size;i++){
            important[priorities[i]]++;
            list.add(new print(priorities[i],i));
            max = Math.max(max,priorities[i]);
        }
       
        while(true){
            print current = list.get(0);
            if(current.importance<max){
                list.addLast(current);
                list.removeFirst();
            }else{
                if(current.index==location){
                    break;
                }
                important[current.importance]--;
                if(important[current.importance]<=0){
                    for(int i=9;i>=1;i--){
                        if(important[i]>0){
                            max = i;
                            break;
                        }
                    }
                }
                list.removeFirst();
                answer++;
            }
        }
        
        return answer+1;
    }
    
    static class print{
        int importance;
        int index;
        public print(int importance,int index){
            this.importance = importance;
            this.index = index;
        }
    }
}