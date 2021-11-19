import java.util.LinkedList;
class Solution {
    public int solution(int[][] board, int[] moves) {
        LinkedList buckets = new LinkedList<Integer>();
        int addNum =0;
        int N = board.length;
        for(int m=0; m<moves.length;m++){
            int crane=moves[m]-1;
            for(int i=0; i<N;i++){
                if(board[i][crane]!=0){
                    addNum++;
                    if(buckets.size()!=0 &&(int)buckets.getLast()==board[i][crane] ){
                        buckets.removeLast();
                    }
                    else buckets.add(board[i][crane]);
                    board[i][crane]=0;
                    break;
                }
            }
        }
        return addNum-buckets.size();
    }
}