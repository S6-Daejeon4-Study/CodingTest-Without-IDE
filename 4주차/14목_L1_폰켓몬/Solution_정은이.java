import java.util.HashMap;
class Solution {
    int[] selected = null;
    int max=0;
    public int solution(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int a : nums){
            Integer integerA = new Integer(a);
            if(map.containsKey(integerA)) map.put(integerA,new Integer(map.get(integerA).intValue()+1));
            else map.put(integerA,1);
        }
        if(map.size()>=nums.length/2) return nums.length/2;
        else return map.size();
    }
}