import java.util.ArrayList;

public class PRO81302_거리두기확인하기 {
	final int N = 5;
    final int PERSON = 'P';
    final int EMPTY = 'O';
    final int PARTITION = 'X';
    public int[] solution(String[][] places) {
        int total = places.length;
        int[] answer = new int[total];
        ArrayList<int[]> person;
        for(int n = 0 ; n < total ; n++) {
            boolean isPossible = true;
            person = new ArrayList<>();
            for(int i = 0 ; i < N ; i++) { 
                for(int j = 0 ; j < N ; j++) {
                    if(places[n][i].charAt(j) == PERSON) {
                        person.add(new int[]{i, j});
                    }
                }
            }
            for(int i = 0 ; i < person.size() - 1 ; i++) {
                for(int j = i + 1 ; j < person.size() ; j++) {
                    int[] p1 = person.get(i);
                    int[] p2 = person.get(j);
                    int dist = Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
                    if(dist == 1) {
                        isPossible = false;
                        break;
                    }
                    if(dist == 2) {
                        int ni = (p1[0] + p2[0]) / 2;
                        int nj = (p1[1] + p2[1]) / 2;
                        if(((p1[0] + p2[0]) & 1) == 1) {
                            if(places[n][ni].charAt(nj) == PERSON && (places[n][ni + 1].charAt(nj) == EMPTY || places[n][ni].charAt(nj + 1) == EMPTY)) {
                                isPossible = false;
                                break;
                            }
                            else if(places[n][ni].charAt(nj) != PERSON && (places[n][ni].charAt(nj) == EMPTY || places[n][ni + 1].charAt(nj + 1) == EMPTY)) {
                                isPossible = false;
                                break;
                            }
                        } else if(((p1[0] + p2[0]) & 1) == 0 && places[n][ni].charAt(nj) == EMPTY) {  
                            isPossible = false;
                            break;
                            
                        }
                    }
                }
                if(!isPossible) break;
            }
            
            if(isPossible) answer[n] = 1;
            else answer[n] = 0;
        }
        
        return answer;
    }
}
