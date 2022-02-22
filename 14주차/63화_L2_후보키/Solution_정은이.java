import java.util.*;
class Solution {
    boolean[] isSelected;
    int columnLength,rowLength;
    Set<String> candidate;
    public int solution(String[][] relation) {
        int answer = 0;
        columnLength = relation[0].length;
        rowLength = relation.length;
        isSelected = new boolean[columnLength];
        candidate = new HashSet<>();
        
        subset(0,"",relation);
        return candidate.size();
    }
    public void subset(int target,String s,String[][] relation){
        if(target==columnLength){
            Set<String> set = new HashSet<>();
            for(int i=0;i< rowLength;i++){
                String tuple="";
                for(int t=0; t<s.length();t++){
                    tuple+=relation[i][s.charAt(t)-'0'];
                }
                set.add(tuple); 
            }
            if(rowLength==set.size()&&checkminimum(s)) candidate.add(s);          
            return;
        }
        
        if(checkminimum(s)) subset(target+1,s,relation);
        if(checkminimum(s+target)) subset(target+1,s+target,relation);
        
    }
    public boolean checkminimum(String s){
        boolean atomic = false;
        String removeC="";
        check: for(String c :candidate){
            
            if(c.contains(s)) return false;
            if(s.contains(c)) return false;
            
        
            if(s.length()<=c.length()){
                for(int t=0; t<s.length();t++){
                    if(!c.contains(s.charAt(t)+"")) break;
                    if(t==s.length()-1) {
                        atomic = true;
                        removeC=c;
                    }
                }
            }
            else{
                for(int t=0; t<c.length();t++){
                    if(!s.contains(c.charAt(t)+"")) break;
                    if(t==c.length()-1) return false;
                }
                
            }
        }
        if(atomic) candidate.remove(removeC);
        return true;
    }
    
}