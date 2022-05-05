package programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// int배열로 변환 안하고 string배열인 arr 그대로 써도 되네...
public class PRO64065_튜플_재 {
    public int[] solution(String s) {
        String[] arr = s.replace("{{", "").replace("}}", "").split("\\},\\{");
        int[][] list = new int[arr.length][];
        int[] answer = new int[arr.length];
        for(int i = 0 ; i < arr.length ; i++) {
            String[] split = arr[i].split(",");
            list[i] = new int[split.length];
            for(int j = 0 ; j < split.length ; j++) {
                list[i][j] = Integer.parseInt(split[j]);
            }
        }
        Arrays.sort(list, (o1, o2) -> o1.length - o2.length);

        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < list.length ; i++) {
            for(int j = 0 ; j < list[i].length ; j++) {
                if(!set.contains(list[i][j])) {
                    set.add(list[i][j]);
                    answer[i] = list[i][j];
                }
            }
        }

        return answer;
    }
}
