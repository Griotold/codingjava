package it_big_company_problem.ch7_BFS;

import java.util.LinkedList;
import java.util.Queue;
/**
 * 송아지가 움직이기 때문에 ch 배열을 함부로 사용할 수가 없다.
 * */
public class 송아지찾기_3 {
    /**
     * 내 풀이 - 미완성
     * */
    public int solution(int s, int e){
        int answer = -1;
        int dis = 1;
        int[] ch = new int[200001];
        int[] dx = {1, -1, 2};
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        ch[s] = 1;
        int L = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();

            for(int i = 0; i < len; i++) {
                int cur = queue.poll();
                if(cur == e) return L;
                for(int j = 0; j < 3; j++) {
                    int next;
                    next = cur + dx[j];
                    if(j == 2) next = cur * 2;
//                    if(next == e) return L + 1;
                    if(next >= 0 && next <= 200000 && ch[next] == 0) {
                        ch[next] = 1;
                        queue.offer(next);
                    }
                }
            }
            L++;
            e += dis++;
        }
        return answer;
    }

    /**
     * 정답 풀이
     */
    public int solByTeacher(int s, int e) {
        int[][] ch = new int[2][200001];
        Queue<Integer> Q = new LinkedList<>();
        ch[0][s] = 1;
        Q.offer(s);
        int L = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            L++;
            for (int i = 0; i < len; i++) {
                int x = Q.poll();
                for (int nx : new int[]{x - 1, x + 1, x * 2}) {
                    if (nx >= 0 && nx <= 200000 && ch[L % 2][nx] == 0) {
                        ch[L % 2][nx] = 1;
                        Q.offer(nx);
                    }
                }
            }
            e = e + L;
            if(e > 200000) return -1;
            if(ch[L%2][e] == 1) return L;
        }
        return -1;
    }

    public static void main(String[] args){
        송아지찾기_3 T = new 송아지찾기_3();
        System.out.println(T.solution(1, 11));
        System.out.println(T.solution(10, 3));
        System.out.println(T.solution(1, 34567));
        System.out.println(T.solution(5, 6));
        System.out.println(T.solution(2, 54321));
    }
}
