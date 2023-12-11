package it_big_company_problem.ch3_data_structure;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 현관문출입순서_3 {
    public int[] solution(int[] arrival, int[] state){
        Queue<Integer> enter = new LinkedList<>();
        Queue<Integer> exit = new LinkedList<>();
        int n = arrival.length;
        int prev = 1;
        int[] answer = new int[n];
        for (int t = 0, i = 0, cnt = 0; ; t++) {
            // 두 큐가 비어 있으나 아직 도착할 사원이 남아 있을 때
            if (enter.isEmpty() && exit.isEmpty() && i < n) {
                if (t < arrival[i]) {
                    t = arrival[i];
                    prev = 1;
                }
            }

            // 큐에 넣는 작업
            while (i < n && arrival[i] <= t) {
                if(state[i] == 0) enter.offer(i);
                else exit.offer(i);
                i++;
            }

            // 조건에 따라 answer값 세팅
            if (prev == 1) {
                if (!exit.isEmpty()) {
                    answer[exit.poll()] = t;
                    prev = 1;
                } else {
                    answer[enter.poll()] = t;
                    prev = 0;
                }
            } else if (prev == 0) {
                if (!enter.isEmpty()) {
                    answer[enter.poll()] = t;
                    prev = 0;
                } else {
                    answer[exit.poll()] = t;
                    prev = 1;
                }
            }
            cnt++;
            if (cnt == n) break;
        }
        return answer;
    }

    public static void main(String[] args){
        현관문출입순서_3 T = new 현관문출입순서_3();
        System.out.println(Arrays.toString(T.solution(new int[]{0, 1, 1, 1, 2, 3, 8, 8}, new int[]{1, 0, 0, 1, 0, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{3, 3, 4, 5, 5, 5}, new int[]{1, 0, 1, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{2, 2, 2, 3, 4, 8, 8, 9, 10, 10}, new int[]{1, 0, 0, 0, 1, 1, 0, 1, 1, 0})));
    }
}
