package it_big_company_problem.ch4_sorting_and_thinking;

import java.util.Arrays;
import java.util.Collections;

public class 카드가져가기_3 {
    /**
     * 내 풀이
     * */
    public int solution(int[] nums, int k){
        int answer = 0;
        int n = nums.length;
        // 1. 내림차순 정렬 -> Integer[]로 변환해야함
        Integer[] integerNums = new Integer[n];
        for (int i = 0; i < n; i++) {
            integerNums[i] = nums[i];
        }
        // Integer[]로 변환 후 내림차순 정렬
        Arrays.sort(integerNums, Collections.reverseOrder());

        // 2. 우선권을 사용하지 않았을 때 현수가 받을 총점
        for (int i = 1; i < n; i += 2) {
            answer += integerNums[i];
        }

        // 3. diff 배열
        Integer[] diff = new Integer[n/2];
        int index = 0;
        for (int i = 0; i < n ; i += 2) {
            diff[index++] = integerNums[i] - integerNums[i+1];
        }

        // 4. diff 배열 내림차순 정렬
        Arrays.sort(diff, Collections.reverseOrder());

        // 5. 우선권 횟수만큼 현수의 최종값에 더해주기
        for (int i = 0; i < k; i++) {
            answer += diff[i];
        }

        return answer;
    }

    /**
     * 정답
     */
    public int solByTeacher(int[] nums, int k) {
        int answer = 0;
        int n = nums.length;
        Integer[] tmp = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(tmp, (a, b) -> b - a);
        Integer[] diff = new Integer[n/2];
        for (int i = 0; i < n / 2; i++) {
            answer += tmp[i*2+1];
            diff[i] = tmp[i*2] - tmp[i*2+1];
        }
        Arrays.sort(diff, (a, b) -> b - a);
        for (int i = 0; i < k; i++) {
            answer += diff[i];
        }
        return answer;
    }

    public static void main(String[] args){
        카드가져가기_3 T = new 카드가져가기_3();
        System.out.println(T.solution(new int[]{7, 8, 5, 12, 3, 1, 3, 1, 1, 12}, 2));
        System.out.println(T.solution(new int[]{8, 2, 12, 12, 12, 12, 2, 2}, 2));
        System.out.println(T.solution(new int[]{3, 7, 12, 3, 3, 5, 7, 8, 9, 11, 23, 4, 6, 7}, 3));
        System.out.println(T.solution(new int[]{12, 34, 56, 23, 22, 34, 55, 45, 24, 23, 45, 55, 55, 23, 11, 12, 23, 12}, 3));
        System.out.println(T.solution(new int[]{14, 15, 20, 11, 10, 20, 20, 12, 9, 22, 27, 25, 30, 19}, 3));
    }
}
