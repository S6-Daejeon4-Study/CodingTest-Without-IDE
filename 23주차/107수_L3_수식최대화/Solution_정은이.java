import java.util.*;

class Solution {
        List<Long> numList;
        List<Character> operatorList;
        List<Character> operatorSetList;
        Character[] order;
        boolean[] used;
        long max;
    public long solution(String expression) {
        numList = new ArrayList<>();
        operatorList = new ArrayList<>();
        operatorSetList = new ArrayList<>();
        max=0;
        
        StringBuilder num = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (Character.isDigit(c)) num.append(c);
            else {
                numList.add(Long.parseLong(num.toString()));
                num.delete(0, num.length());
                if(!operatorSetList.contains(c))operatorSetList.add(c);
                operatorList.add(c);
            }
        }
        numList.add(Long.parseLong(num.toString()));
        int N = operatorSetList.size();
        order = new Character[N];
        used = new boolean[N];
        perm(N,0);

        return max;
    }

    public void perm(int N, int cnt) {
        if (cnt == N) {
            List<Long> tmpNumList = new ArrayList<>();
            tmpNumList.addAll(numList);
            List<Character> tmpOperatorList = new ArrayList<>();
            tmpOperatorList.addAll(operatorList);
            for (char o : order) {
                calculateLine(tmpNumList, tmpOperatorList,o);
            }
            long tmp =  Math.abs(tmpNumList.get(0));
            max=Math.max(max, tmp);
            return;
        }
        for (int i = 0; i < N ; i++) {
            if(used[i])continue;
            used[i]=true;
            order[cnt]=operatorSetList.get(i);
            perm(N,cnt+1);
            used[i]=false;
        }
    }

    public void calculateLine(List<Long> numList, List<Character> operatorList, Character operator) {
        for (int i = 0; i < operatorList.size(); i++) {
//            if(i>= operatorList.size()) return;
            if (operatorList.get(i) == operator) {
                long a = numList.get(i);
                long b = numList.get(i + 1);
                numList.remove(i);
                numList.remove(i);
                operatorList.remove(i);
                numList.add(i, calculate(a, b, operator));
                i--;
            }
        }
//        operatorList.remove(operator);
    }

    public long calculate(long a, long b, char operator) {
        if (operator == '*') return a * b;
        if (operator == '-') return a - b;
        if (operator == '+') return a + b;
        return -1;
    }
}