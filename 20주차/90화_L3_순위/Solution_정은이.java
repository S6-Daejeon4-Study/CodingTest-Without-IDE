import java.util.*;
class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        Node[] nodes = new Node[n];
        boolean[] visited;
        for(int i=0;i<n;i++)
           nodes[i]=new Node();
        
        ArrayList<Integer>[] map = init(n,results);
        
        for(int i=0;i<n;i++){
            visited = new boolean[n];
            dfs(i,i,nodes,map,visited);
        }
        
        for(Node node : nodes){
            if((node.up+node.down)==n-1) answer++;
        }
        return answer;
    }
    public ArrayList<Integer>[] init(int n, int[][] results){
        ArrayList<Integer>[] map = new ArrayList[n];
        for(int i=0;i<n;i++)
            map[i]=new ArrayList<>();
        
        for(int[] r: results)
            map[r[0]-1].add(r[1]-1);
        
        return map;
    }
    public void dfs(int a, int i, Node[] nodes, ArrayList<Integer>[] map,boolean[] visited){
        if(a!=i){
            nodes[a].down++;
            nodes[i].up++;
        }
        // if(map[a].size()==0) return;
        visited[a]=true;
        for(Integer loser : map[a])
            if(!visited[loser]) dfs(loser,i,nodes,map,visited);
        
        
    }
    public class Node{
        int up,down;
    }
}