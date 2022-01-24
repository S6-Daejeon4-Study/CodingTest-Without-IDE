import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        //인접 리스트
        Node[] adjList = new Node[n+1];
        
        int E = edge.length;
        for(int i=0;i<E;i++){
            int from = edge[i][0];
            int to = edge[i][1];
            adjList[from] = new Node(to,adjList[from]);
            adjList[to] = new Node(from,adjList[to]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        
        queue.offer(1);
        visited[1] = true;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            answer = size;
            while(size-->0){
                int current = queue.poll();
                
                for(Node temp=adjList[current]; temp!=null;temp=temp.link){
                    if(!visited[temp.vertex]){
                        queue.offer(temp.vertex);
                        visited[temp.vertex] = true;
                    }
                }
            }
        }
        
        
        return answer;
    }
    
    static class Node{
        int vertex;
        Node link;
        public Node(int vertex, Node link){
            this.vertex = vertex;
            this.link = link;
        }
    }
}