import java.util.*;

class Solution {
    
    static int[][] temp;
    static int keySize;
    static int lockSize;
    static int size;
    static int[][] map;
    static int[][] Key;
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
        
        Key=key;
        keySize = key.length;
        lockSize = lock.length;
        //키 복사
        temp = new int[keySize][keySize];
        for(int i=0;i<keySize;i++){
            for(int j=0;j<keySize;j++){
                temp[i][j] = key[i][j];
            }
        }
        
        size = lockSize+(2*keySize)-2;
        
        map = new int[size][size];
        //맵의 가운데는 자물쇠
        for(int i=0;i<lockSize;i++){
            for(int j=0;j<lockSize;j++){
                map[i+keySize-1][j+keySize-1] = lock[i][j];
            }
        }
        
       for(int d=0;d<4;d++){
           rotate();
           
           for(int i=0;i<=size-keySize;i++){
               for(int j=0;j<=size-keySize;j++){
                   //맵에 키 0,0부터 복사해보기
                   for(int a=0;a<keySize;a++){
                       for(int b=0;b<keySize;b++){
                           map[a+i][b+j] += temp[a][b];
                       }
                   }
                   
                   if(check()){
                       return true;
                   }
                   //안맞으면 다시 되돌리기
                   for(int a=0;a<keySize;a++){
                       for(int b=0;b<keySize;b++){
                           map[a+i][b+j] -= temp[a][b];
                       }
                   }
               }
           }
       }
        
        return false;
    }
    
    static boolean check(){
        
         for(int i=0;i<lockSize;i++){
            for(int j=0;j<lockSize;j++){
                if(map[i+keySize-1][j+keySize-1]==0 || map[i+keySize-1][j+keySize-1]==2){
                    return false;
                }
            }
        }
        return true;
    }
    
    static void rotate(){
        int[][] temp2 = new int[keySize][keySize];
        
        for(int i=0;i<keySize;i++){
            for(int j=0;j<keySize;j++){
                temp2[j][keySize-i-1] = temp[i][j];
            }
        }
        
        temp = temp2;
    }
}