package it_big_company_problem.ch6_DFS;

import java.util.Stack;

/**
 * 강사님 풀이 - Stack 활용
 * */
public class 줄다리기_2_2 {
    static int answer;
    static Stack<Integer> pm;
    static int[][] relation;
    static int[] ch;

    public void DFS(int L) {
        if(L == 7) answer++;
        else {
            for (int i = 1; i < 8; i++) {
                if(!pm.isEmpty() && relation[pm.peek()][i] == 1) continue;
                if (ch[i] == 0) {
                    ch[i] = 1;
                    pm.push(i);
                    DFS(L + 1);
                    ch[i] = 0;
                    pm.pop();
                }
            }
        }
    }
    public int solution(int[][] fight){
        answer = 0;
        pm = new Stack<>();
        relation = new int[8][8];
        for (int[] ints : fight) {
            relation[ints[0]][ints[1]] = 1;
            relation[ints[1]][ints[0]] = 1;
        }
        ch = new int[8];
        DFS(0);
        return answer;
    }

    public static void main(String[] args){
        줄다리기_2_2 T = new 줄다리기_2_2();
        System.out.println(T.solution(new int[][]{{1, 3}, {5, 7}, {4, 2}}));
        System.out.println(T.solution(new int[][]{{3, 2}, {3, 5}, {5, 2}, {7, 3}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {1, 5}, {1, 7}, {1, 3}}));
        System.out.println(T.solution(new int[][]{{1, 7}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
    }
}
