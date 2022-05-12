import java.util.*;

class Solution {
    static HashMap<Integer, Integer> map = null;
    public int solution(int n) {
        map = new HashMap<Integer, Integer>();
        map.put(0, 0);
        map.put(1, 1);
        map.put(2, 1);
        int answer = fibo(n);
        return answer;
    }
    
    public int fibo(int n){   
        if(n <= 0)
            return 0;
        if(n <= 2)
            return 1;
        if(map.get(n) != null)
            return map.get(n);
        
        int sum = (fibo(n-1) + fibo(n-2)) % 1234567;
        map.put(n, sum);
        return map.get(n);
    }
}
