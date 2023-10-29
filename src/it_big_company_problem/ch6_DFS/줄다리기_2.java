package it_big_company_problem.ch6_DFS;
/**
 * 내가 푼 풀이
 * */
public class 줄다리기_2 {
    static int answer = 0;
    static int[] ch;
    static int[] perm;
    static int[][] relation;
    public void DFS(int L) {
        if(L == 7) {
            answer++;
        } else {
            for(int i = 1; i <= 7; i++) {
                if(ch[i] == 0 && relation[i][perm[L]] == 0) {
                    ch[i] = 1;
                    perm[L + 1] = i;
                    DFS(L + 1);
                    ch[i] = 0;
                }
            }
        }
    }

    public int solution(int[][] fight){
        answer = 0;
        ch = new int[8];
        perm = new int[8];
        // 1. relation 테이블 초기화
        relation = new int[8][8];
        for(int i = 0; i < fight.length; i++) {
            int a = fight[i][0];
            int b = fight[i][1];
            relation[a][b] = 1;
            relation[b][a] = 1;
        }
        DFS(0);
        return answer;
    }

    public static void main(String[] args){
        줄다리기_2 T = new 줄다리기_2();
        System.out.println(T.solution(new int[][]{{1, 3}, {5, 7}, {4, 2}}));
        System.out.println(T.solution(new int[][]{{3, 2}, {3, 5}, {5, 2}, {7, 3}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {1, 5}, {1, 7}, {1, 3}}));
        System.out.println(T.solution(new int[][]{{1, 7}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
    }
}
