import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
public class PRO42579_베스트앨범 {
	class Solution {
	    public int[] solution(String[] genres, int[] plays) {
	        LinkedList<Integer> result = new LinkedList<>();
	        Map<String, PriorityQueue<Music>> map = new HashMap<>();
	        PriorityQueue<Genre> genreList = new PriorityQueue<>();
	        for(int i = 0 ; i < genres.length ; i++){
	            PriorityQueue<Music> musics = map.get(genres[i]);
	            if(musics == null) {
	                musics = new PriorityQueue<>();
	                map.put(genres[i], musics);
	            }
	            musics.add(new Music(i, plays[i]));
	        }
	        
	        for(String genre : map.keySet()) {
	            PriorityQueue<Music> musics = map.get(genre);
	            int sum = 0;
	            for(Music m : musics) {
	                sum += m.plays;
	            }
	            genreList.offer(new Genre(genre, sum));
	        }
	        
	        while(!genreList.isEmpty()) {
	            Genre genre = genreList.poll();
	            PriorityQueue<Music> musics = map.get(genre.name);
	            //System.out.println(genre.totalPlays);
	            result.add(musics.poll().idx);
	            if(!musics.isEmpty()) {
	                result.add(musics.poll().idx);
	            }
	        }
	        
	        
	        int[] answer = new int[result.size()];
	        int i = 0;
	        for(Integer idx : result) {
	            answer[i++] = idx;
	        }
	        return answer;
	    }
	    public class Genre implements Comparable<Genre>{
	        String name;
	        int totalPlays;
	        public Genre(String name, int totalPlays) {
	            this.name = name;
	            this.totalPlays = totalPlays;
	        }
	        public int compareTo(Genre o) {
	            return o.totalPlays - this.totalPlays;
	        }
	    }
	    public class Music implements Comparable<Music>{
	        int idx, plays;
	        public Music(int idx, int plays) {
	            this.idx = idx;
	            this.plays = plays;
	        }
	        public int compareTo(Music o) {
	            if(this.plays > o.plays) return -1;
	            else if(this.plays < o.plays) return 1;
	            else return this.idx - o.idx;
	        }
	    }
	}
}
