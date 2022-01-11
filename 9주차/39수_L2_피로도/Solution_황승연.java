class Solution {
    static int num;
    static boolean[] isSelected;
    static int max;
    public int solution(int k, int[][] dungeons) {
           
        num = dungeons.length;
        isSelected = new boolean[num];
        max = 0;
        perm(0,k,0,dungeons);
        
        return max;
    }
    
    static void perm(int cnt,int tired,int size,int[][] dungeons){
        if(cnt==num){
            max = Math.max(size,max);
            return;
        }
        
        for(int i=0;i<num;i++){
            if(isSelected[i]){
                continue;
            }
            if(tired>=dungeons[i][0]){
                isSelected[i] = true;
                perm(cnt+1,tired-dungeons[i][1],size+1,dungeons);
                
            }else{
                perm(cnt+1,tired,size,dungeons);
            }
            isSelected[i]=false;
            
        }
    }
}