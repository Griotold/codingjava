package it_big_company_problem.ch4_sorting_and_thinking;
import java.util.*;
public class 멀티태스킹_6 {
    /**
     * 내 풀이 - 오답
     * */
    public int solution(int[] tasks, long k) {
        int n = tasks.length;
        // 1. 배열 복사한 후 0을 추가하기. 그리고 정렬
        int[] st = Arrays.copyOf(tasks, n + 1);
        st[n] = 0;
        Arrays.sort(st);

        // 2. 가능한 만큼 회전
        int rest = n;
        int i;
        for (i = 1; i <= n; i++) {
            int iter = rest * (st[i] - st[i - 1]);
            if (k - iter >= 0) {
                k -= iter;
                rest--;
            } else {
                k %= rest;
                break;
            }
        }

        // 3. 잔처리
        int index = 0;
        while(k > 0) {
            if (tasks[index] >= st[i]) {
                index++;
                k--;
            } else {
                index++;
            }
        }
        return index + 1;
    }

    /**
     * 정답
     * */
    public int solByTeacher(int[] tasks, long k) {
        int answer = 0;
        int[] sT = new int[tasks.length + 1];
        System.arraycopy(tasks, 0, sT, 1, tasks.length);
        Arrays.sort(sT);

        int rest = tasks.length;
        for (int i = 1; i < sT.length; i++) {
            long time = (long) rest * (sT[i] - sT[i - 1]);
            if (k < time) {
                long idx = k % rest;
                int cnt = 0;
                for (int j = 0; j < tasks.length; j++) {
                    if (tasks[j] >= sT[i]) {
                        if (cnt == idx) return j + 1;
                        cnt++;
                    }
                }
            } else {
                k -= time;
                rest--;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        멀티태스킹_6 T = new 멀티태스킹_6();
        System.out.println(T.solByTeacher(new int[]{1, 2, 3}, 5));
        System.out.println(T.solByTeacher(new int[]{8, 5, 2, 9, 10, 7}, 30));
        System.out.println(T.solByTeacher(new int[]{8, 9, 12, 23, 45, 16, 25, 50}, 100));
    }
}
