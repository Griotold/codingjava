import java.util.*;

class Solution {
    static int[] ch;
    public int solution(int[] pool, int a, int b, int home){
        int answer = -1;
        ch = new int[10001];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int L = 0;
        ch[0] = 1;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                int now = queue.poll();
                int forward = now + a;
                int back = now - b;
                for(int j = 0; i < pool.length; j++) {
                    if(forward <= 10000 && ch[forward] == 0 && forward != pool[j]) {
                        ch[forward] = 1;
                        queue.offer(forward);
                    }
                    if(back > 0 && ch[back] == 0 && back != pool[j]) {
                        ch[back] = 1;
                        queue.offer(back);
                    }
                }
                if(forward == home) return L + 1;
                if(back == home) return L + 1;
            }
            L++;
        }
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{11, 7, 20}, 3, 2, 10));
//        System.out.println(T.solution(new int[]{1, 15, 11}, 3, 2, 5));
//        System.out.println(T.solution(new int[]{9, 15, 35, 30, 20}, 2, 1, 25));
//        System.out.println(T.solution(new int[]{5, 12, 7, 19, 23}, 3, 5, 18));
//        System.out.println(T.solution(new int[]{10, 15, 20}, 3, 2, 2));
    }
}
