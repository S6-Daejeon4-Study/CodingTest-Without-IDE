import java.util.*;
class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        boolean zero=false;
        int a=0;
        while(n>0){
            a = n%3;
            n/=3;
            if(!zero){
                if(a==0) {
                    sb.append(4);
                    n-=1;
                }
                else sb.append(a);
            }
            if(n==0) zero=true;
        }
        sb.reverse();
        return sb.toString();
    }
}