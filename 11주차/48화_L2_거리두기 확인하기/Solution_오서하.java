class Solution {
    public int[] solution(String[][] places) {
        int di[] = {-2, 0, 2, 0, -1, 1, 1, -1};
        int dj[] = {0, 2, 0, -2, 1, 1, -1, -1};
        int checki[] = {-1, 0, 1, 0};
        int checkj[] = {0, 1, 0, -1};
        
        int answer[] = new int[5];
        for(int u = 0 ;  u  < 5 ; u ++){
            char [][] place = new char[5][5];
            boolean flag = false;
            for(int d = 0 ; d < 5 ; d++){
                place[d] = places[u][d].toCharArray();
            }
            oter : for(int i = 0 ; i < 5 ; i ++){   
                for(int j = 0 ; j < 5 ; j++){
                    if(place[i][j] == 'P'){ // 현재 자리에 누군가 앉아 있다면, 8방향(거리가 2미만) 탐색할거야.
                        for(int k = 0; k < 4 ; k++){ // 거리가 1인 곳에 앉아있나 체크
                            int ni = i + checki[k];
                            int nj = j + checkj[k];
                            if(!isPossible(ni, nj)) continue;     
                            if(place[ni][nj] == 'P'){
                                flag = true;
                                break oter;
                            }   
                        }
                        for(int k = 0; k < 8 ; k++){ // 거리가 2인 곳에 앉아 있나 체크
                            int ni = i + di[k];
                            int nj = j + dj[k];          
                            if(!isPossible(ni, nj)) continue;
                            if(place[ni][nj] == 'P' && k < 4){ // k = 0~3
                                int chi = i + checki[k];
                                int chj = j + checkj[k];
                                
                                if(place[chi][chj] != 'X'){
                                    flag = true;     
                                    break oter;
                                } 
                            }
                            else if(place[ni][nj] == 'P' && k > 3 && k < 8) { // k =4~7
                                int r = k % 4;
                                for(int c = 0 ; c < 2 ; c++){
                                    if( r == 4) r = 0;
                                    int chi = i + checki[r];
                                    int chj = j + checkj[r];
                                 
                                    if(place[chi][chj] != 'X'){
                                        flag = true;     
                                        break oter;
                                    }
                                    r++;
                                }
                            }
                        } // 8 방향 for 종료
                    } // 현재 자리에서 누군가가 앉아 있다면 내 인접한 12자리 보는 if문 종료
                }
            }
            if(flag) answer[u] = 0;
            else answer[u] = 1;
        }
        return answer;
    }
    
    static boolean isPossible(int ni, int nj){
        if( ni < 0 || ni >= 5 || nj < 0 || nj >= 5){
            return false;
        }
        return true;
    }
}