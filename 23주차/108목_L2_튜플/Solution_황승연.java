import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        
        Map<String,Integer> map = new HashMap<>();
        
        s=s.replace("{","");
        s=s.replace("},"," ");
        String[] arr = s.split(" ");
        int size = arr.length;
        arr[size-1] = arr[size-1].replace("}","");
        
        for(int i=0;i<arr.length;i++){
            String str = arr[i];
            String[] temp = str.split(",");
            
            for(int j=0;j<temp.length;j++){
                //System.out.print(temp[j]+" ");
                map.put(temp[j],map.getOrDefault(temp[j],0)+1);
            }
        }
        
        PriorityQueue<Number> pq = new PriorityQueue<>();
        for(String str:map.keySet()){
            pq.offer(new Number(Integer.parseInt(str),map.get(str)));
        }
        
        answer = new int[pq.size()];
        for(int i=0;i<answer.length;i++){
            answer[i]=pq.poll().num;
        }
        
        return answer;
    }
    
    static class Number implements Comparable<Number>{
        int num;
        int cnt;
        public Number(int num,int cnt){
            this.num=num;
            this.cnt=cnt;
        }
        public int compareTo(Number o){
            return o.cnt-this.cnt;
        }
    }
}