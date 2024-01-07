package it_big_company_problem.ch5_greedy;

import java.util.Arrays;
import java.util.Comparator;

public class 스프링쿨러_3{
    public int solution(int n, int[] nums){
        int answer = 0;
        // 1. 2차원 배열 line -> 시작값으로 오름차순 정렬
        int[][] line = new int[n+1][2];
        for (int i = 0; i <= n; i++) {
            int range = nums[i];
            line[i][0] = (i - range) < 0 ? 0 : i - range;
            line[i][1] = Math.min(n, i + nums[i]);
        }
        Arrays.sort(line, Comparator.comparingInt(a -> a[0]));

        // 2. 순회 - 그리디
        int start = 0, end = 0, i = 0;
        while (i < line.length) {
            while (i < line.length && line[i][0] <= start) {
                end = Math.max(end, line[i][1]);
                i++;
            }
            answer++;
            if (end == n) return answer;
            if (start == end) return -1;
            start = end;
        }

        return answer;
    }

    public static void main(String[] args){
        스프링쿨러_3 T = new 스프링쿨러_3();
        System.out.println(T.solution(8, new int[]{1, 1, 1, 2, 1, 1, 2, 1, 1}));
        System.out.println(T.solution(4, new int[]{1, 2, 2, 0, 0}));
        System.out.println(T.solution(5, new int[]{2, 0, 0, 0, 0, 2}));
        System.out.println(T.solution(11, new int[]{1, 2, 3, 1, 2, 1, 1, 2, 1, 1, 1, 1}));
    }
}
