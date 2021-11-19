import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        int size = board.length;
        
        Stack<Integer> basket = new Stack<>();
        
        for(int i=0;i<moves.length;i++){
            //크레인 위치
            int position = moves[i]-1;
            //크레인 위치에서 내려가면서 인형 찾기
            for(int j=0;j<size;j++){
                int doll = board[j][position];
                //인형 발견하면
                if(doll!=0){
                    if(!basket.isEmpty()){
                        int before = basket.peek();
                        //같은 인형 연속인지 확인
                        if(doll==before){
                             basket.pop();
                            answer+=2;
                         }else{
                            basket.add(doll);
                         }   
                    }else{
                        basket.add(doll);
                    }
                    //뽑은 인형 없애기
                    board[j][position]=0;
                    break; 
                    
                }
            }  
        }
        return answer;
    }
}