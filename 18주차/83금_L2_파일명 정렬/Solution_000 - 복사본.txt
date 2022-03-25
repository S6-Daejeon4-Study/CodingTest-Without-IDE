import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        int length=files.length;
        File[] sortedFiles = new File[length];
        for(int i=0; i< length;i++){
            sortedFiles[i] = new File(files[i],i);
        }
        Arrays.sort(sortedFiles);
        String[] answer = new String[length];
        for(int i=0; i< length;i++){
            answer[i]=sortedFiles[i].name;
        }
        return answer;
    }
    public class File implements Comparable<File>{
        String head,name;
        int num,idx;
        public File(String s,int idx){
            this.name=s;
            this.idx=idx;
            
            int find=0;
            int startNumIdx=0;
            int endIdx=-1;
            for(int i=0; i< s.length();i++){
                if(find==0&&Character.isDigit(s.charAt(i))){
                    find=1;
                    head = s.substring(0,i).toUpperCase();
                    startNumIdx=i;
                    continue;
                }
                if(find==1){
                    if(startNumIdx+5==i || !Character.isDigit(s.charAt(i))){
                        endIdx=i;
                        break;
                    }
                }
            }
            if(endIdx==-1) endIdx=s.length();
            num = Integer.parseInt(s.substring(startNumIdx,endIdx));
        }
        @Override
        public int compareTo(File o){
            if(o.head.equals(this.head)) {
                if(this.num==o.num) return this.idx-o.idx;
                return this.num-o.num;
            }
            return this.head.compareTo(o.head);
        }
    }
}