package it_big_company_problem.ch5_greedy;

import java.util.*;
public class 꽃이피는최단시간_4 {

    /**
     * 내 풀이
     * */
    public int solution(int[] plantTime, int[] growTime){
        int answer = 0;
        int n = plantTime.length;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] arr = new int[2];
            arr[0] = plantTime[i];
            arr[1] = growTime[i];
            list.add(arr);
        }
        list.sort((a, b) -> b[1] - a[1]);

        int s = 0;
        int e = 0;
        for (int i = 0; i < n; i++) {
            e = s + list.get(i)[0] + list.get(i)[1];
            answer = Math.max(e, answer);
            s += list.get(i)[0];
        }
        return answer;
    }

    /**
     * 정답
     * */
    public int solByTeacher(int[] plantTime, int[] growTime) {
        int answer = 0;
        int n = plantTime.length;
        int[][] list = new int[n][2];
        for (int i = 0; i < n; i++) {
            list[i][0] = plantTime[i];
            list[i][1] = growTime[i];
        }
        Arrays.sort(list, (a, b) -> b[1] - a[1]);
        int start = 0;
        int end = 0;
        for (int [] x : list) {
            end = start + x[0] + x[1];
            answer = Math.max(answer, end);
            start += x[0];
        }
        return answer;
    }

    public static void main(String[] args){
        꽃이피는최단시간_4 T = new 꽃이피는최단시간_4();
        System.out.println(T.solution(new int[]{1, 3, 2}, new int[]{2, 3, 2}));
        System.out.println(T.solution(new int[]{2, 1, 4, 3}, new int[]{2, 5, 3, 1}));
        System.out.println(T.solution(new int[]{1, 1, 1}, new int[]{7, 3, 2}));
        System.out.println(T.solution(new int[]{5, 7, 10, 15, 7, 3, 5}, new int[]{6, 7, 2, 10, 15, 6, 7}));
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{7, 5, 4, 3, 2, 1, 6}));
    }
}
