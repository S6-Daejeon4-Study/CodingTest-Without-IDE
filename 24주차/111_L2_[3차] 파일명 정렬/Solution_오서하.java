import java.util.*;

class Solution {
    public String[]  solution(String[] files) {
        String[] answer = new String[files.length];
        String numRegExp = "[0-9]+";
        String stringRegExp = "[^0-9]+";
        ArrayList<File> list = new ArrayList<File>();

        for(int i = 0 ; i < files.length; i++) {
            String head = files[i].split(numRegExp)[0];
            String number = files[i].substring(head.length(), files[i].length()).split(stringRegExp)[0];
            String tale = files[i].substring(head.length()+number.length(),files[i].length());
            
            File file = new File(head, number, tale);
            list.add(file);
        }
            
        FileComparator fileComparator = new FileComparator();
        Collections.sort(list, fileComparator);
        
        for(int i = 0 ; i < list.size() ; i++){
            File f = list.get(i);
            String ans = f.head+f.number+f.tale;
            answer[i] = ans;
        }

        return answer;
    }
    
    class File{
        String head ,number, tale;
        
        public File(String head, String number, String tale){
            this.head = head;
            this.number = number;
            this.tale = tale;
        }
    }
    
    class FileComparator implements Comparator<File>{
        
        public int compare(File f1, File f2){ 
            String head1 = f1.head.toLowerCase();
            String head2 = f2.head.toLowerCase();
            
            int num1 = Integer.parseInt(f1.number);
            int num2 = Integer.parseInt(f2.number);
            
            if(head1.compareTo(head2) != 0)
                return head1.compareTo(head2);
            else{
                if(num1 != num2)
                    return num1 - num2;
                else 
                    return 0;
            }           
        } 
    }
}
