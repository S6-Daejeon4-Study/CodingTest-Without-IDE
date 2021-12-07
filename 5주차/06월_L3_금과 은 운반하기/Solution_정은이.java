import java.util.PriorityQueue;
class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
//        int gold=0;
//        int silver=0;
        PriorityQueue<TimeAndIdx> pq = new PriorityQueue<>();
        // 모든 화물 출발
        for (int i = 0; i < t.length; i++) {
            pq.add(new TimeAndIdx(t[i], i));
        }
        //시간이 빠른 순으로 오기
        while (!pq.isEmpty()) {
            TimeAndIdx curTruck = pq.poll();
            // 금과 은 중에 어떤 광물을 가져오는게 더 유리한지 체크

            // 골드 실버 중에 많이 가져올 수 있는 친구 한가지만 정해서 가져오기
            int possibleGold = Math.min(w[curTruck.idx], g[curTruck.idx]);
            int possibleSilver = Math.min(w[curTruck.idx], s[curTruck.idx]);

            if (a <= 0 && possibleSilver > 0) { // 필요한 골드가 없을 경우
                b -= possibleSilver;
                s[curTruck.idx] -= possibleSilver;
            } else if (b <= 0 && possibleGold > 0) { // 필요한 실버가 없을 경우
                a -= possibleGold;
                g[curTruck.idx] -= possibleGold;
            } else { // 골드랑 실버가 남았을 경우

                if (possibleGold > possibleSilver) { // 가지고 올 수 있는 골드의 양이 실버보다 클 경우
                    if (a < possibleGold) {
                        g[curTruck.idx] -= a;
                        int tmpSilver = Math.min(s[curTruck.idx], w[curTruck.idx] - a);
                        s[curTruck.idx] -= tmpSilver;
                        b -= tmpSilver;
                        a = 0;
                    } else {
                        a -= possibleGold;
                    }

                } else {
                    if (b < possibleSilver) {
                        s[curTruck.idx] -= b;
                        int tmpGold = Math.min(g[curTruck.idx], w[curTruck.idx] - b);
                        g[curTruck.idx] -= tmpGold;
                        a -= tmpGold;
                        b = 0;
                    } else {
                        b -= possibleSilver;
                    }
                }
            }

            if (a <= 0 && b <= 0) return curTruck.time;
            // if (g[curTruck.idx] > 0 && s[curTruck.idx] > 0)
                pq.add(new TimeAndIdx(curTruck.time + (long) t[curTruck.idx] * 2, curTruck.idx));

        }
        return 1L;
    }

    class TimeAndIdx implements Comparable<TimeAndIdx> {
        long time;
        int idx; // i 번째

        public TimeAndIdx(long time, int idx) {
            this.time = time;
            this.idx = idx;
        }

        @Override
        public int compareTo(TimeAndIdx o) {
            return (int) (this.time - o.time) / 1000000;
        }

    }
}