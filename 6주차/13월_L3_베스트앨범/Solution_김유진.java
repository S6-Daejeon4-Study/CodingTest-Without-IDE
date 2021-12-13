import java.util.*;

class Solution {
    static HashMap<String, PriorityQueue<Song>> record;
	static HashMap<String, Integer> cnt;
    public int[] solution(String[] genres, int[] plays) {
		int len = genres.length;
		record = new HashMap<>();
		cnt = new HashMap<>();
		for (int i = 0; i < len; i++) {
			if (record.containsKey(genres[i]))
				record.get(genres[i]).add(new Song(i, plays[i]));
			else{
				record.put(genres[i], new PriorityQueue<Song>());
                record.get(genres[i]).add(new Song(i, plays[i]));
            }
			if (cnt.containsKey(genres[i])) {
				int tmpCnt = cnt.get(genres[i]);
				tmpCnt += plays[i];
				cnt.put(genres[i], tmpCnt);
			} else{
				cnt.put(genres[i], plays[i]);
            }
		}
		PriorityQueue<Gerne> tmp = new PriorityQueue<>();
		Iterator<String> iter = cnt.keySet().iterator();
		while (iter.hasNext()) {
			String name = iter.next();
			tmp.add(new Gerne(name, cnt.get(name)));
		}
        
        
        
	    int len2 = tmp.size();
        int ansCnt = 0;
        Queue<Integer> ansTmp = new LinkedList<Integer>();
        for(int i = 0; i<len2 ; i++){
            String gname = tmp.poll().g;
            
            int tmpCnt = record.get(gname).size() >= 2 ? 2 : record.get(gname).size();
            // System.out.println(gname + "장르 : " + tmpCnt);
            for(int j = 0; j<tmpCnt ;j++){
                ansTmp.offer(record.get(gname).poll().idx);    
            }
            ansCnt += tmpCnt;
        }
        
        
        
		int[] answer = new int[ansCnt];
        for(int i = 0; i< ansCnt;i++){
            answer[i] = ansTmp.poll();
        }
        
        
		return answer;
	}

	static class Gerne implements Comparable<Gerne> {
		String g;
		int cnt;

		public Gerne(String g, int cnt) {
			this.g = g;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Gerne o) {
			return -Integer.compare(this.cnt, o.cnt);
		}
	}

	static class Song implements Comparable<Song> {
		int idx, cnt;

		public Song(int idx, int cnt) {
			this.idx = idx;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Song o) {
			if (this.cnt == o.cnt)
				return Integer.compare(this.idx, o.idx);
			else
				return -Integer.compare(this.cnt, o.cnt);
		}
	}
}