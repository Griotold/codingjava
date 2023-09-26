import java.util.*;

class Solution {
    public int solution(int[] dot) {
        int answer = 0;
        if(dot[0] > 0) {
            if(dot[1] > 0) {
                answer = 1;
            } else {
                answer = 3;
            }
        } else {
            if(dot[1] > 0) {
                answer = 2;
            } else {
                answer = 4;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] dot1 = {1, 2};
        int[] dot2 = {1, -2};
        int[] dot3 = {-1, 2};
        int[] dot4 = {-1, -2};
        Solution T = new Solution();
        System.out.println(T.solution(dot1));
        System.out.println(T.solution(dot2));
        System.out.println(T.solution(dot3));
        System.out.println(T.solution(dot4));
    }
}
