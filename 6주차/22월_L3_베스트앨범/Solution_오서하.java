import java.util.*;
import java.util.Map.Entry;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        HashMap <String, Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < genres.length ; i++){
            if(map.containsKey(genres[i])){ // 해당 장르가 맵에 있다면.
                map.put(genres[i], map.get(genres[i]) + plays[i]);
            }
            else{ // 장르가 맵에 없다면.
                map.put(genres[i], plays[i]);
            }
        }
        
        List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String, Integer>>(map.entrySet());
        
        Collections.sort(list_entries, new Comparator<Entry<String, Integer>>(){
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2){
                return o2.getValue().compareTo(o1.getValue()); // 재생횟수가 높은 장르 순으로 정렬 (내림차순)
            }
        });
        
        PriorityQueue<Song> queue = new PriorityQueue<>(); 
        
         for(int i = 0 ; i < genres.length ; i++){
             for(int j = 0 ; j < map.size(); j++){
                 if(genres[i].equals(list_entries.get(j).getKey())){ 
                    queue.add(new Song(j,i,plays[i]));
                }
             }
         }
        
        ArrayList<Integer> ans = new ArrayList<>();
        // 장르 인덱스 - plays - index 순
        int genre = -1;
        int genreCnt = 0;
        while(!queue.isEmpty()){
            Song now = queue.poll();
          
            if(genre == -1 || (genre == now.genre_idx && genreCnt < 2)) { 
                // 맨 처음 이거나 앞서 뽑힌 장르와 지금 뽑힌 장르가 동일 할 경우
                genre = now.genre_idx;
                genreCnt ++;
                ans.add(now.index);
            }
            else if(genre != -1 && genre != now.genre_idx ){ //앞서 뽑힌 장르와 다른 장르가 뽑힌것
                genre = now.genre_idx;
                genreCnt = 1;
                ans.add(now.index);
            }
        }
        int[] answer = new int[ans.size()];
        for(int i = 0 ; i < ans.size() ; i++){
            answer[i] = ans.get(i);
        }                        
        return answer;
    }
    
    class Song implements Comparable<Song>{
        int genre_idx;
        int index;
        int plays;
        
        public Song(int genre_idx, int index, int plays ){
            this.genre_idx = genre_idx;
            this.index = index;
            this.plays = plays;
        }
        
        public int compareTo(Song o1){
            if(this.genre_idx == o1.genre_idx){ // 동일한 장르일 경우
                if(this.plays == o1.plays){ // 재생횟수가 동일하다면
                    return this.index - o1.index; // 인덱스가 낮은 순으로  오름차순
                }else{ // 재생횟수가 다르다면
                    return o1.plays - this.plays; // 내림차순으로 
                }
            }
            else{
                return this.genre_idx - o1.genre_idx; // 다른 장르 일 경우, 오름차순 정렬(숫자가 낮은 장르가 우선순위)
            }
        }
    }
}