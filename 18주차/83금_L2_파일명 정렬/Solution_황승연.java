import java.util.*;

class Solution {
    static String[] Files;
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        
        this.Files=files;
        
        PriorityQueue<File> pq = new PriorityQueue<>();
        
        for(int i=0;i<files.length;i++){
            String str = files[i];
            String head="";
            String number="";
            String tail="";
            boolean flag=false;
            for(int j=0;j<str.length();j++){
                char c = str.charAt(j);
                
                c= (c+"").toLowerCase().charAt(0);
                
                if(!flag && (c-'0'<0 || c-'0'>9)){
                    head+=(c+"");
                }else if(!flag && (c-'0'>=0 || c-'0'<=9)){
                    for(int k=j;k<str.length();k++){
                        char check = str.charAt(k);
                        if(check-'0'<0 || check-'0'>9){
                            j=k-1;
                            break;
                        }
                        number+=(check+"");
                    }
                    flag=true;
                }else if(flag){
                    tail+=(c+"");
                }
                
            }
            
            pq.offer(new File(head,number,tail,i));
        }
        
        for(int i=0;i<files.length;i++){
            answer[i]=files[pq.poll().index];
        }
        
        return answer;
    }
    
    static class File implements Comparable<File>{
        String head;
        String number;
        String tail;
        int index;
        public File(String head,String number,String tail,int index){
            this.head=head;
            this.number=number;
            this.tail=tail;
            this.index=index;
        }
        
        public int compareTo(File o){
            
            if(this.head.equalsIgnoreCase(o.head)){
                if(Integer.parseInt(this.number)==Integer.parseInt(o.number)){
                    return this.index-o.index;
                }
                return Integer.parseInt(this.number)-Integer.parseInt(o.number);
            }
            return this.head.compareTo(o.head);
        }
    }
}