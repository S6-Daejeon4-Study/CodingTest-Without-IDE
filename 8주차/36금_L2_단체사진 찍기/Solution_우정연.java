
public class PRO1835_단체사진찍기 {
	class Solution {
	    int SIZE = 8, answer = 0, N;
	    boolean[] visited;
	    String[] conditions;
	    String s = "ACFJMNRT";
	    public int solution(int n, String[] data) {
	        visited = new boolean[SIZE];
	        N = n;
	        conditions = data;
	        perm(0, "");
	        
	        return answer;
	    }
	    public void perm(int idx, String order) {
	        if(idx == SIZE) {
	            if(isValid(order)) {
	                answer++;
	            }
	            return;
	        }
	        for(int i = 0 ; i < SIZE ; i++) {
	            if(visited[i]) continue;
	            visited[i] = true;
	            perm(idx + 1, order + s.charAt(i));
	            visited[i] = false;
	        }
	    }
	    public boolean isValid(String order) {
	        for(int i = 0 ; i < N ; i++) {
	            char a = conditions[i].charAt(0);
	            char b = conditions[i].charAt(2);
	            char op = conditions[i].charAt(3);
	            int num = (conditions[i].charAt(4) - '0') + 1;
	            int start = 1, end = 7;
	            int sub = Math.abs(order.indexOf(a) - order.indexOf(b));
	            switch(op) {
	                case '=' :
	                    start = end = num;
	                    break;
	                case '<' :
	                    end = num - 1;
	                    break;
	                case '>' :
	                    start = num + 1;
	                    break;
	            }
	            if(sub < start || sub > end) return false;
	        }
	        return true;
	    }
	}
}
