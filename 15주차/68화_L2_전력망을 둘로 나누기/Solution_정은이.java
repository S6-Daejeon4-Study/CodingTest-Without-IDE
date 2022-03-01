import java.util.*;
class Solution {
    Map<Integer,Integer> childCntMap;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        Map<Integer,ArrayList<Integer>> map = new HashMap<>();
        childCntMap = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        
        for(int[] wire : wires){
            int a = wire[0];
            int b = wire[1];
            set.add(a);
            set.add(b);
            if(map.containsKey(a)) map.get(a).add(b);
            else {
                ArrayList<Integer> aChildList = new ArrayList<>();
                aChildList.add(b);
                map.put(a,aChildList);
            }
            if(map.containsKey(b)) map.get(b).add(a);
            else {
                ArrayList<Integer> bChildList = new ArrayList<>();
                bChildList.add(a);
                map.put(b,bChildList);
            }
        }
        int wireCnt = set.size();
        for(Integer parent : map.keySet()){
            ArrayList<Integer> list  = map.get(parent);
            if(list.size()==1) continue;
            for(Integer child : list){
                int childCnt=1;
                if(childCntMap.containsKey(child)) {
                    childCnt += childCntMap.get(child);
                }
                else {
                    childCnt += findChild(child,map,parent);
                }
                answer = Math.min(answer,Math.abs((wireCnt - childCnt) - childCnt));
            }
        }
        
        return answer;
    }
    public int findChild(int key, Map<Integer,ArrayList<Integer>> map, int parent){       
        ArrayList<Integer> childList = map.get(key);
        if(childList.size()==1) return 0;

        int childCnt =  childList.size()-1;
        for(Integer c : childList){
            if(c==parent) continue;
            if(childCntMap.containsKey(c)) childCnt += childCntMap.get(c);
            else {
                int cChildCnt =  findChild(c,map,key);
                childCnt += cChildCnt;
                childCntMap.put(c, cChildCnt);
            }
        }
        childCntMap.put(key,childCnt);
        return childCnt;
    }
}