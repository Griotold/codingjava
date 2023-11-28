package it_big_company_problem.ch4_sorting_and_thinking;

import java.util.Arrays;
import java.util.HashMap;

public class 수열찾기_2 {
    public int[] solution(int[] nums){
        int[] answer = new int[nums.length / 2];
        int idx = 0;

        // 1. 해싱
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 2. 정렬
        Arrays.sort(nums);

        // 3. 반복문
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.get(num) > 0) {
                map.put(num, map.get(num) - 1);
                map.put(num * 2, map.get(num * 2) - 1);
                answer[idx++] = num;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        수열찾기_2 T = new 수열찾기_2();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 10, 2, 3, 5, 6})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 1, 6, 2, 2, 7, 3, 14})));
        System.out.println(Arrays.toString(T.solution(new int[]{14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14})));
    }
}
