import java.util.*;

class Solution {
    static boolean[] isSelected;
    static int ans;
    static String result;
    static int conditions;
    static String[] dataes;
    static char[] arr;
    public int solution(int n, String[] data) {
        
        String str = "ACFJMNRT";
        arr = str.toCharArray();
        isSelected = new boolean[8];
        result="";
        conditions = n;
        dataes = data;
        ans=0;
        
        perm(0);
        
        return ans;
    }
    
    static void perm(int cnt){
        if(cnt==8){
            //조건 확인
            for(int i=0;i<conditions;i++){
                String str = dataes[i];
                
                int first = result.indexOf(str.charAt(0));
                int second = result.indexOf(str.charAt(2));
                char check = str.charAt(3);
                int num = (int)(str.charAt(4)-'0');
                
                if(check=='='){
                    if(Math.abs(first-second)-1!=num){
                        return;
                    }
                }else if(check=='<'){
                    if(Math.abs(first-second)-1>=num){
                        return;
                    }
                }else if(check=='>'){
                    if(Math.abs(first-second)-1<=num){
                        return;
                    }
                }
            }

            ans++;
            return;
        }
        
        for(int i=0;i<8;i++){
            if(isSelected[i]){
                continue;
            }
            
            isSelected[i]=true;
            result+=arr[i];
            perm(cnt+1);
            isSelected[i]=false;
            result = result.substring(0,cnt);
        }  
        
    }
}