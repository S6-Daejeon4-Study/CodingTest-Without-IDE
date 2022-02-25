package programmers;

import java.util.*;

public class PRO64065_튜플 {
    class Solution {
        boolean[] isChooseArr;
        final int SIZE = 100001;
        public int[] solution(String s) {
            ArrayList<Integer> tuple = new ArrayList<>();
            int[][] list = changeList(s);
            isChooseArr = new boolean[SIZE];
            for(int i = 0 ; i < list.length ; i++) {
                for(int j = 0 ; j < list[i].length ; j++) {
                    if(!isChooseArr[list[i][j]]) {
                        tuple.add(list[i][j]);
                        isChooseArr[list[i][j]] = true;
                        break;
                    }
                }
            }

            int[] answer = new int[tuple.size()];
            int idx = 0;
            for(Integer n : tuple) {
                answer[idx++] = n;
            }

            return answer;
        }
        int[][] changeList(String s) {
            String[] sArr = s.split("},");
            int[][] list = new int[sArr.length][];
            for(int i = 0 ; i < sArr.length ; i++) {
                String[] nowSArr = sArr[i].split(",");
                int[] arr = new int[nowSArr.length];
                for(int j = 0 ; j < nowSArr.length ; j++) {
                    arr[j] = Integer.parseInt(nowSArr[j].replaceAll("[^0-9]*", ""));
                }
                list[i] = arr;
            }

            Arrays.sort(list, new Comparator<int[]>(){
                public int compare(int[] arr1, int[] arr2) {
                    return arr1.length - arr2.length;
                }
            });
            return list;
        }
    }
}
