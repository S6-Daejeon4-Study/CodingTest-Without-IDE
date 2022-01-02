import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<genres.length;i++){
            int genrePlaySum=0;
            if(map.containsKey(genres[i])) genrePlaySum=map.get(genres[i]);
            map.put(genres[i],genrePlaySum+plays[i]);
        }
        
        PriorityQueue<Song> pq = new PriorityQueue<Song>();
         for(int i=0;i<genres.length;i++){
            pq.add(new Song(i,genres[i],plays[i],map.get(genres[i])));
        }
        
        ArrayList<Integer> bestList = new ArrayList<>();
        String genre;
        for(int i=0;i<map.size();i++){
            Song s=pq.poll();
            genre=s.genre;
            bestList.add(s.idx);
            int cnt=1;
            while(!pq.isEmpty()){
                Song nextSong = pq.peek();
                if(genre.equals(nextSong.genre)){
                    if(cnt==1){
                        cnt++;
                        bestList.add(nextSong.idx);
                    }
                     nextSong=pq.poll();
                }
                else break;
            }
        
        }
        int[] answer = new int[bestList.size()];
             for(int i=0;i<bestList.size();i++){
                 answer[i]=bestList.get(i);
             }
        return answer;
    }
    class Song implements Comparable<Song>{
        int idx;
        String genre;
        int playCnt;
        int genrePlayCnt;
        public Song(int idx, String genre , int playCnt,int genrePlayCnt){
            this.idx = idx;
            this.genre=genre;
            this.playCnt = playCnt;
            this.genrePlayCnt=genrePlayCnt;
        }
        @Override
        public int compareTo(Song o){
            if(this.genrePlayCnt==o.genrePlayCnt){
                if(this.playCnt==o.playCnt){
                   return this.idx-o.idx;
                }else return o.playCnt-this.playCnt;
            }else return o.genrePlayCnt-this.genrePlayCnt;
        }
    }
}