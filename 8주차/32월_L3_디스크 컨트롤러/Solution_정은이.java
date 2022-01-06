import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer=0;
        PriorityQueue<Disk> pq = new PriorityQueue<>();
        ArrayList<Disk> list = new ArrayList<>();
        
        for(int[] a: jobs){
            list.add(new Disk(a[0],a[1]));
        }
        Collections.sort(list, new StartComp());
        
        int time=0;
        int idx=0;
        int size=list.size();
       
        while(true){
            if(idx==size) {
                while(!pq.isEmpty()){
                    Disk current = pq.poll();
                    time+=current.doing;
                    answer+=(time-current.start);
                }
                break;
            }
            if(time<list.get(idx).start){
                if(!pq.isEmpty()){
                    Disk current = pq.poll();
                    time+=current.doing;
                    answer+=(time-current.start);
                }
                else{
                    time=Math.max(time,list.get(idx).start);
                    time+=list.get(idx).doing;
                    answer+=list.get(idx).doing;

                    idx++;                    
                }
                continue;

            }
            else{
                pq.add(list.get(idx));
                idx++;
            }
  
        }
        return answer/size;
    }
    class StartComp implements Comparator<Disk>{
		@Override
		public int compare(Disk o1, Disk o2) { //o1이 기준이면 오름차순, o2기준이면 내림차순
            if(o1.start==o2.start) return o1.doing-o2.doing;
			return o1.start-o2.start;
		} 
		
	}  
    class Disk implements Comparable<Disk>{
        int start;
        int doing;
        public Disk(int start,int doing){
            this.start=start;
            this.doing=doing;
        }
        @Override
        public int compareTo(Disk o){
            return this.doing-o.doing;
        }
    }
}