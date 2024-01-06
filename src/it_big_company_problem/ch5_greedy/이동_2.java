package it_big_company_problem.ch5_greedy;

import java.util.Arrays;

public class 이동_2 {
    public int solution(int[] nums){
        int answer = 0;
        // 1. 정렬
        Arrays.sort(nums);
        int lt = 0;
        int rt = nums.length - 1;
        while(lt <= rt) {
            if (nums[lt] + nums[rt] <= 5) {
                answer++;
                rt--;
                lt++;
            } else {
                answer++;
                rt--;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        이동_2 T = new 이동_2();
        System.out.println(T.solution(new int[]{2, 5, 3, 4, 2, 3}));
        System.out.println(T.solution(new int[]{2, 3, 4, 5}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3}));
    }
}
