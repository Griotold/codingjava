import java.util.*;

class Solution {
    private int getTime(String time) {
        int hour = Integer.parseInt(time.split(":")[0]);
        int minute = Integer.parseInt(time.split(":")[1]);
        return hour * 60 + minute;
    }
    public int solution(int[] laser, String[] enter){
        int answer = 0;
        int n = enter.length;
        int[][] inList = new int[n][2];
        Queue<Integer> waiting = new LinkedList<>();

        // 1. inList 초기화
        for (int i = 0; i < n; i++) {
            String time = enter[i].split(" ")[0];
            int intTime = getTime(time);
            int laserIndex = Integer.parseInt(enter[i].split(" ")[1]);
            inList[i][0] = intTime;
            inList[i][1] = laserIndex;
        }

        // 시뮬레이션
        int ft = inList[0][0];
        for (int t = ft, i = 0; t <= 1200; t++) {
            if (waiting.isEmpty() && ft < t) {
                ft = t;
            }

            if (t == inList[i][0]){
                waiting.offer(inList[i][1]);
                i++;
            }

            if (ft == t) {
                if (!waiting.isEmpty()) {
                    ft += laser[waiting.poll()];
                }
            }
            answer = Math.max(answer, waiting.size());
            if (i == n) break;
        }
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0", "15:25 0"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:20 1", "10:40 1", "11:00 1", "11:20 1", "11:40 1"}));
    }
}
