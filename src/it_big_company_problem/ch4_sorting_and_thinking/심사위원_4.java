package it_big_company_problem.ch4_sorting_and_thinking;

import java.util.*;

public class 심사위원_4 {
    public int solution(int[] score, int k) {
        int answer = 0;
        // 정렬 80, 85, 91, 92, 95, 97, 99
        Arrays.sort(score);

        // 반복 중에서 첫 번째 세 번째 요소의 차이가 10점 이하면 answer 후보
        for(int i = 0; i < score.length - k + 1; i++) {
            int temp = score[i + k - 1] - score[i];
            if (temp > 10) continue;
            int sum = 0;
            for (int j = i; j < k + i; j++) {
                sum += score[j];
            }
            return answer = sum / k;
        }

        // answer를 만나자 마자 리턴

        return answer;
    }
    /**
     * 정답
     * */
    public int solByTeacher(int[] score, int k) {
        int n = score.length;
        Arrays.sort(score);
        for (int i = 0; i <= n - k; i++) {
            if (score[i + k - 1] - score[i] <= 10)
                return getAve(score, i, i + k - 1);
        }
        return 0;
    }

    private int getAve(int[] score, int start, int end) {
        int sum = 0;
        for(int i = start; i <= end; i++) {
            sum += score[i];
        }
        return sum / (end - start + 1);

    }

    public static void main(String[] args){
        심사위원_4 T = new 심사위원_4();
        System.out.println(T.solution(new int[]{99, 97, 80, 91, 85, 95, 92}, 3));
        System.out.println(T.solution(new int[]{92, 90, 77, 91, 70, 83, 89, 76, 95, 92}, 4));
        System.out.println(T.solution(new int[]{77, 88, 78, 80, 78, 99, 98, 92, 93, 89}, 5));
        System.out.println(T.solution(new int[]{88, 99, 91, 89, 90, 72, 75, 94, 95, 100}, 5));

    }
}
