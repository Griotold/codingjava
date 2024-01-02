package it_big_company_problem.ch5_greedy;

import java.util.Arrays;

public class 침몰하는타이타닉_1 {
    public int solution(int[] nums, int m){
        int answer = 0;
        // 1. 정렬
        Arrays.sort(nums);
        int lt = 0, rt = nums.length - 1;
        while (lt <= rt) {
            if (lt == rt) {
                answer++;
                break;
            }
            if (nums[lt] + nums[rt] <= m) {
                answer++;
                lt++;
                rt--;
            } else {
                answer++;
                rt--;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        침몰하는타이타닉_1 T = new 침몰하는타이타닉_1();
        System.out.println(T.solution(new int[]{90, 50, 70, 100, 60}, 140));
        System.out.println(T.solution(new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90}, 100));
        System.out.println(T.solution(new int[]{68, 72, 30, 105, 55, 115, 36, 67, 119, 111, 95, 24, 25, 80, 55, 85, 75, 83, 21, 81}, 120));
    }
}
