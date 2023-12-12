package it_big_company_problem.ch3_data_structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class CPU스케줄링_5 {
    public int[] solution(int[][] tasks){
        int n = tasks.length;
        ArrayList<Integer> res = new ArrayList<>();
        LinkedList<int[]> programs = new LinkedList<>();

        // 1. programs 초기화
        for (int i = 0; i < n; i++) {
            programs.add(new int[]{tasks[i][0], tasks[i][1], i});
        }

        // 2. programs 정렬 : 호출시간을 기준으로
        programs.sort((a, b) -> a[0] - b[0]);

        // 3. 우선순위 큐
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int ft = 0;
        while (!programs.isEmpty() || !pq.isEmpty()) {
            if (pq.isEmpty()) ft = Math.max(ft, programs.peek()[0]);
            while (!programs.isEmpty() && programs.peek()[0] <= ft) {
                int[] x = programs.pollFirst();
                pq.add(new int[]{x[1], x[2]});
            }
            int[] ex = pq.poll();
            ft += ex[0];
            res.add(ex[1]);
        }

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) answer[i] = res.get(i);
        return answer;
    }

    public static void main(String[] args){
        CPU스케줄링_5 T = new CPU스케줄링_5();
        System.out.println(Arrays.toString(T.solution(new int[][]{{2, 3}, {1, 2}, {8, 2}, {3, 1}, {10, 2}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{5, 2}, {7, 3}, {1, 3}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{1, 2}, {2, 3}, {1, 3}, {3, 3}, {8, 2}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{999, 1000}, {996, 1000}, {998, 1000}, {999, 7}})));
    }
}
