package it_big_company_problem.ch4_sorting_and_thinking;

import java.util.Arrays;

public class 이진수정렬_1 {
    public int[] solution(int[] nums) {
        int[] answer = new int[nums.length];

        // 1. 이진수로 변환했을 때 1의 개수가 몇개인지를 담는 2차원 배열
        int[][] res = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            int cnt = 0;
            int tmp = nums[i];
            while (tmp > 0) {
                cnt += (tmp % 2);
                tmp = tmp / 2;
            }
            res[i][0] = nums[i];
            res[i][1] = cnt;
        }
        // 2. 1의 개수로 오름차순 정렬
        Arrays.sort(res, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        for (int i = 0; i < res.length; i++) {
            answer[i] = res[i][0];
        }
        return answer;
    }

    public static void main(String[] args) {
        이진수정렬_1 T = new 이진수정렬_1();
        System.out.println(Arrays.toString(T.solution(new int[]{5, 6, 7, 8, 9})));
        System.out.println(Arrays.toString(T.solution(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(T.solution(new int[]{12, 5, 7, 23, 45, 21, 17})));
    }
}
