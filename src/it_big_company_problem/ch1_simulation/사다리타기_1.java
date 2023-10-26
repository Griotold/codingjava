package it_big_company_problem.ch1_simulation;

import java.util.Arrays;

public class 사다리타기_1 {
    /**
     * 내 풀이
     * */
    public char[] solution(int n, int[][] ladder){
        char[] answer = new char[n];
        // 1. answer에 알파벳 초기화
        for(int i = 0; i < n; i++) {
            answer[i] = (char) (65 + i);
//            System.out.print(answer[i] + " ");
        }
        // 2. 이중 for문으로 동시에 사다리 타기
        for (int[] across : ladder) {
            for (int i = 0; i < across.length; i++) {
                char tmp = answer[across[i] - 1];
                answer[across[i] - 1] = answer[across[i]];
                answer[across[i]] = tmp;
            }
        }
        return answer;
    }

    /**
     * 강사님 풀이 - 동일
     * 코딩 스타일의 차이
     */
    public char[] solByTeacher(int n, int[][] ladder) {
        char[] answer = new char[n];
        for (int i = 0; i < n; i++) {
            answer[i] = (char)(i + 65);
        }

        for (int[] line : ladder) {
            for (int x : line) {
                char tmp = answer[x];
                answer[x] = answer[x - 1];
                answer[x - 1] = tmp;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        사다리타기_1 T = new 사다리타기_1();
        System.out.println(Arrays.toString(T.solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
        System.out.println(Arrays.toString(T.solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
        System.out.println(Arrays.toString(T.solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
        System.out.println(Arrays.toString(T.solution(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));
    }
}
