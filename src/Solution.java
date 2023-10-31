import java.util.*;

class Solution {
    public int solution(int[] nums){
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            int j;
            for (j = i; j < nums.length - 1; j++) {
                if(nums[j] >= nums[j + 1]) break;
                count++;
            }
            for (int k = j; k < nums.length - 1; k++) {
                if(nums[k] <= nums[k + 1]) break;
                count++;
            }
            answer = Math.max(answer, count);
        }
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{1, 3, 2, 5, 7, 4, 2, 5, 1}));
        System.out.println(T.solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
        System.out.println(T.solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
        System.out.println(T.solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
    }
}
