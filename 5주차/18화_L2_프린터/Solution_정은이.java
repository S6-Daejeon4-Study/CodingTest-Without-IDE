import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        List<int[]> list = new ArrayList<>();
        for(int i=0;i<priorities.length;i++){
            list.add(new int[]{priorities[i],i});
        }
        int orderNum=1;
        outer:while(!list.isEmpty()){
            int[] first = list.get(0);
            list.remove(0);
          
            for(int j=0; j<list.size();j++){
                if(first[0]< list.get(j)[0]) {
                    list.add(first);
                    continue outer;
                }
            }
            if(first[1]==location) return orderNum;
            orderNum++;
        }
        return orderNum;
        
    }
}