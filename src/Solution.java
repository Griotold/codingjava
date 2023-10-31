import java.util.*;

class Solution {
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
//                if(cur == e) return L;
                for(int j = 0; j < 3; j++) {
                    int next;
                    next = cur + dx[j];
                    if(j == 2) next = cur * 2;
                    if(next == e + dis) return L + 1;
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

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(1, 11));
        System.out.println(T.solution(10, 3));
        System.out.println(T.solution(1, 34567));
        System.out.println(T.solution(5, 6));
        System.out.println(T.solution(2, 54321));
    }
}
