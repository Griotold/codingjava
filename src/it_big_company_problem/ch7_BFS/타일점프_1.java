package it_big_company_problem.ch7_BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 현재 위치(index)를 Queue에 넣는 것이 포인트!
 * */
public class 타일점프_1 {
    static int[] ch;
    public int solution(int[] nums){
        int answer = -1;
        ch = new int[101];
        ch[0] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int L = 0, market = nums.length - 1;
        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                int x = queue.poll();
                for(int j = 1; j <= nums[x]; j++) {
                    int nx = x + j;
                    if(nx == market) return L + 1;
                    if(nx < nums.length && ch[nx] == 0){
                        ch[nx] = 1;
                        queue.offer(nx);
                    }
                }
            }
            L++;
        }
        return answer;
    }

    public static void main(String[] args){
        타일점프_1 T = new 타일점프_1();
        System.out.println(T.solution(new int[]{2, 2, 1, 2, 1, 1}));
        System.out.println(T.solution(new int[]{1, 0, 1, 1, 3, 1, 2, 1}));
        System.out.println(T.solution(new int[]{2, 3, 1, 0, 1, 1, 2, 3, 1, 5, 1, 3, 1}));
        System.out.println(T.solution(new int[]{1, 2, 1, 2, 1, 2, 1, 1, 3, 1, 2, 1}));
        System.out.println(T.solution(new int[]{1, 3, 2, 1, 1, 2, 3, 1, 3, 1, 2, 3, 5, 1, 5, 1, 2, 1, 1}));
    }
}
