package it_big_company_problem.ch7_BFS;

import java.util.LinkedList;
import java.util.Queue;
/**
 * 앞으로 점프했는지, 뒤로 점프했는지 기록해둬야함
 * ch배열도 앞 뒤를 구분해줘야 한다.
 * */
public class 집으로이동_2 {
    public int solution(int[] pool, int a, int b, int home){
        int[][] ch = new int[2][10001];
        for(int x : pool){
            ch[0][x] = 1;
            ch[1][x] = 1;
        }
        Queue<int[]> Q = new LinkedList<>();
        ch[0][0] = 1;
        ch[1][0] = 1;
        Q.offer(new int[]{0, 0});
        int L = 0;
        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i = 0; i < len; i++){
                int[] cur = Q.poll();
                if(cur[0] == home) return L;
                int nx = cur[0] + a;
                if(nx <= 10001 && ch[0][nx] == 0){
                    ch[0][nx] = 1;
                    Q.offer(new int[]{nx, 0});
                }
                nx = cur[0] - b;
                if(nx >= 0 && ch[1][nx] == 0 && cur[1] == 0){
                    ch[1][nx] = 1;
                    Q.offer(new int[]{nx, 1});
                }
            }
            L++;
        }
        return -1;
    }

    public static void main(String[] args){
        집으로이동_2 T = new 집으로이동_2();
        System.out.println(T.solution(new int[]{11, 7, 20}, 3, 2, 10));
        System.out.println(T.solution(new int[]{1, 15, 11}, 3, 2, 5));
        System.out.println(T.solution(new int[]{9, 15, 35, 30, 20}, 2, 1, 25));
        System.out.println(T.solution(new int[]{5, 12, 7, 19, 23}, 3, 5, 18));
        System.out.println(T.solution(new int[]{10, 15, 20}, 3, 2, 2));
    }
}
