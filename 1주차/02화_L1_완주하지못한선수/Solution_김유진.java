import java.util.*;
import java.io.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        int len = completion.length;
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        for(int i = 0; i< len;i++){
            if(!completion[i].equals(participant[i]))
                return participant[i];
        }
        return participant[len];
        
    }
}