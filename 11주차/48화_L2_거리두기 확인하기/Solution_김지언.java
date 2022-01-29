import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        Arrays.fill(answer, 1);
        int[][] delta = {
            {-1, 0}, 
            {0, -1}, 
            {0, 1}, 
            {1, 0}
        };
        
        for(int i = 0; i < places.length; i++) {
            loop : for(int j = 0; j < places[i].length; j++) {
                for(int k = 0; k < places[i][j].length(); k++) {
                    if(places[i][j].charAt(k) == 'P') {
                        for(int d = 0; d < delta.length; d++) {
                            int x = j + delta[d][0];
                            int y = k + delta[d][1];
                            
                            if(x < 0 || y < 0 || x >= 5 || y >= 5) continue;
                            
                            if(places[i][x].charAt(y) == 'P'){
                                answer[i] = 0;
                                break loop;
                            } else if(places[i][x].charAt(y) == 'O') {
                                for(int d2 = 0; d2 < delta.length; d2++) {
                                    int x2 = x + delta[d2][0];
                                    int y2 = y + delta[d2][1];
                                    
                                    if(x2 < 0 || y2 < 0 || x2 >= 5 || y2 >= 5 || (j == x2 && k == y2)) 
                                        continue;
                                    
                                    if(places[i][x2].charAt(y2) == 'P'){
                                        answer[i] = 0;
                                        break loop;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}