import java.util.*;

class Solution {
    static int answer, cnt, N;
    static int[] nums, ch;
    public static void DFS(int L, int number) {
        if(L == cnt) {
            if(N < number) {
                answer = number;
            }
        } else {
            for(int i = 0; i < cnt; i++) {
                if(ch[i] == 0) {
                    ch[i] = 1;
                    DFS(L + 1, number * 10 + nums[i]);
                    ch[i] = 0;
                }
            }
        }
    }
    public int solution(int n){
        // 1. 각 자릿수를 배열에 담고 오름차순 정렬
        // 1-1. 일단 n의 자릿수 구하기
        cnt = 0;
        int tmp = n;
        N = n;
        while(tmp > 0) {
            if(tmp != 0) cnt++;
            tmp /= 10;
        }
        // 1-2. 배열에 담기
        nums = new int[cnt];
        ch = new int[cnt];
        for(int i = 0; i < cnt; i++) {
            nums[i] = n % 10;
            n /= 10;
        }
        // 1-3. 오름차순 정렬
        Arrays.sort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }

        // 2. 순열을 뽑아서 n보다 크면 리턴
        DFS(0, 0);
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(123));
//        System.out.println(T.solution(321));
//        System.out.println(T.solution(20573));
//        System.out.println(T.solution(27711));
//        System.out.println(T.solution(54312));
    }
}
