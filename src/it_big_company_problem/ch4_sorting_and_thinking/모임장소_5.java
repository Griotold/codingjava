package it_big_company_problem.ch4_sorting_and_thinking;

import java.util.*;

public class 모임장소_5 {

    public int solution(int[][] board){
        int answer = 0;
        int count = 0;
        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                if (board[i][j] == 1) {
                    row.add(i);
                    col.add(j);
                    count++;
                }
            }
        }
        Collections.sort(col);
        for(int i = 0; i < count; i++) {
            answer += Math.abs(row.get(count / 2) - row.get(i));
            answer += Math.abs(col.get(count / 2) - col.get(i));
        }

        return answer;
    }
    /**
     * 정답
     * */
    public int solByTeacher(int[][] board) {
        int answer = 0;
        int n = board.length;
        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    row.add(i);
                    col.add(i);
                }
            }
        }
        col.sort((a, b) -> a - b);
        int x = row.get(row.size() / 2);
        int y = col.get(col.size() / 2);
        for (int p : row) answer += Math.abs(x - p);
        for (int p : col) answer += Math.abs(y - p);
        return answer;
    }

    public static void main(String[] args){
        모임장소_5 T = new 모임장소_5();
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 1, 1}, {0, 1, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 1, 1}}));
    }
}
