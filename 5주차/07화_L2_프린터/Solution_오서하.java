
import java.util.LinkedList;
import java.util.Queue;

class Solution {
     int answer = 0;
    Queue<Document> queue = new LinkedList<>();
    public int solution(int[] priorities, int location) {
        
        for(int i = 0 ; i < priorities.length ; i++){
            queue.add(new Document(i, priorities[i]));
        }

        bfs(location);
        
        return answer+1;
    }
    
    public void bfs(int location){
        
        while(!queue.isEmpty()){
            Document d = queue.poll();
            
            if(isExist(d.importance)){
                queue.add(new Document(d.index, d.importance));
            }
            else{
                if(d.index == location){
                    return;
                }
                else{
                    answer ++;
                }
            }
        }
    }
    
    public boolean isExist(int importance){
        for(Document d : queue){
            if(d.importance > importance) return true;
        }
        return false;
    }
    
}

class Document{
    int index;
    int importance;
    
    public Document(int i, int score){
        this.index = i;
        this.importance = score;
    }
}