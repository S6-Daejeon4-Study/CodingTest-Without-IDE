import java.util.*;

public class PRO86053_금과은운반하기2 {
	public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long time = 0, unSSum = 0, gMax = 0, sMax = 0;
        PriorityQueue<Truck> pq = new PriorityQueue<>();
        for(int i = 0 ; i < t.length ; i++) {
        	if(g[i] == 0 && s[i] == 0) continue;
            pq.offer(new Truck(i, t[i], 0));
        }
        
        while(true) {
            // a, b 확인해서 가능하면 break
            if(a == 0 && b == 0) break;
            if((unSSum >= (long)a + (long)b) && a <= gMax && b <= sMax) break;
            
            // pq에서 꺼내서 검사
            Truck truck = pq.poll();
            time = truck.time;		// 시간 갱신
            
            // 1. 금이나 은으로만 이루어진 경우
            if(g[truck.idx] == 0 || s[truck.idx] == 0) {
            	if(g[truck.idx] > 0) {		// 금만 있는 경우
            		int sub = Math.min(a, Math.min(g[truck.idx], w[truck.idx]));
            		g[truck.idx] -= sub;
            		a -= sub;
            	} else {					// 은만 있는 경우
            		int sub = Math.min(b, Math.min(s[truck.idx], w[truck.idx]));
            		s[truck.idx] -= sub;
            		b -= sub;
            	}
            	
            // 금 은 모두 0이 아니면 time + t * 2해서 다시 넣음
            	if(a != 0 || b != 0) {
            		truck.time += t[truck.idx] * 2L;
            		pq.offer(truck);
            	}
            } else {       
            // 2. 둘이 섞여있는 경우
            	// 이전 range 빼고
            	unSSum -= truck.cnt * w[truck.idx];
            	gMax -= Math.min((long)g[truck.idx], (long)w[truck.idx] * truck.cnt);
            	sMax -= Math.min((long)s[truck.idx], (long)w[truck.idx] * truck.cnt);
            	truck.cnt++;
            	// 없앨건지 계산하고
            	// 없애면 -> a, b 갱신
            	if(truck.cnt * (long)w[truck.idx] >= ((long)g[truck.idx] + (long)s[truck.idx])) {
            		a -= Math.min(a, g[truck.idx]);
            		b -= Math.min(b, s[truck.idx]);
            	}
            	// 안없애면 -> range 갱신(map), unSRange 갱신, 시간 갱신해서 다시넣음(pq)
            	else {
            		unSSum += truck.cnt * (long)w[truck.idx];
            		gMax += Math.min((long)g[truck.idx], (long)w[truck.idx] * truck.cnt);
                	sMax += Math.min((long)s[truck.idx], (long)w[truck.idx] * truck.cnt);
            		truck.time += t[truck.idx] * 2L;
            		pq.offer(truck);
            	}
            }
        }
        
        return time;
    }
	class Truck implements Comparable<Truck>{
    	int idx;
    	long time;
    	int cnt;
		public Truck(int idx, long time, int cnt) {
			this.idx = idx;
			this.time = time;
			this.cnt = cnt;
		}

		public int compareTo(Truck o) {
			if(this.time > o.time) return 1;
			else if(this.time < o.time) return -1;
			else return 0;
		}
    }
}
