import java.util.*;

class Solution {
    public List<Integer> solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        int size = plays.length;
        
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<size;i++){
            if(map.containsKey(genres[i])){
                int sum = map.get(genres[i]);
                map.put(genres[i],sum+plays[i]);
            }else{
                map.put(genres[i], plays[i]);   
            }
        }
        
        PriorityQueue<Genre> pq = new PriorityQueue<>();
        for(String key : map.keySet()){
            pq.add(new Genre(key,map.get(key)));
        }
        
        while(!pq.isEmpty()){
            String genre = pq.poll().genre;
            PriorityQueue<song> pq2 = new PriorityQueue<>();
            for(int i=0;i<size;i++){
                if(genres[i].equals(genre)){
                    pq2.add(new song(i,genre,plays[i]));
                }
            }
            int count = 2;
            while(!pq2.isEmpty()){
                answer.add(pq2.poll().index);
                count--;
                if(count==0){
                    break;
                }
            }
        }
        
        return answer;
    }
    
    static class song implements Comparable<song>{
        int index;
        String genre;
        int playTime;
        public song(int index,String genre,int playTime){
            this.index = index;
            this.genre = genre;
            this.playTime = playTime;
        }
        
        @Override
        public int compareTo(song o){
            if(this.playTime==o.playTime){
                return this.index-o.index;
            }else{
                return o.playTime-this.playTime;        
            }
        }
    }
    
    static class Genre implements Comparable<Genre>{
        String genre;
        int sum;
        public Genre(String genre,int sum){
            this.genre = genre;
            this.sum = sum;
        }
        
        @Override
        public int compareTo(Genre o){
            return o.sum-this.sum;
        }
    }
}