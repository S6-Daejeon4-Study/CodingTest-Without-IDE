import java.util.LinkedList;
class Solution {
    static LinkedList<Truck> bridgeOn;
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int len = truck_weights.length;
        int cnt = 0;
        int idx = 0;
        int time = 0;
        int bridge_weight = 0;
        bridgeOn = new LinkedList<Truck>();
        while(cnt!=len){
            if(idx<len && bridge_weight + truck_weights[idx] <= weight){
                time++;
                System.out.println("in time : "+time);
                bridge_weight+=truck_weights[idx];
                bridgeOn.add(new Truck(truck_weights[idx++],time));
            }else{
                Truck tmp = bridgeOn.poll();
                System.out.println("out time : "+(tmp.t + bridge_length));
                //time = Math.max(tmp.t + bridge_length,time);
                time = tmp.t + bridge_length;
                bridge_weight -= tmp.w;
                cnt++;
				// 나가는 순간 다리에 여유가 있으면 새로운 차가 들어올 수 있다.
                if(idx<len && bridge_weight + truck_weights[idx] <= weight){
                    if(!bridgeOn.isEmpty() && time <= bridgeOn.get(bridgeOn.size()-1).t)
                        time = bridgeOn.get(bridgeOn.size()-1).t + 1;
                    System.out.println("in time : "+time);
                    bridge_weight+=truck_weights[idx];
                    bridgeOn.add(new Truck(truck_weights[idx++],time));
                }
            }
        }
        
        return time;
    }
    static class Truck{
        int w, t;
        public Truck(int w, int t){
            this.w = w;
            this.t = t;
        }
    }
}