import java.util.*;

class Solution {
    public int[] solution(int[] nums){
        int n = nums.length;
        int[] answer = new int[n/2];
        // 1. nums의 빈도수를 해싱
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        // 2. nums를 오름차순 정렬한다
        Arrays.sort(nums);

        // 3. answer 만들어주기
        List<Integer> list = new ArrayList<>();
        for (int x : nums) {
            if (map.get(x) == 0) continue;
            else {
                list.add(x);
                map.put(x, map.get(x) - 1);
                map.put(x * 2, map.get(x * 2) - 1);
            }
        }
        for (int i = 0; i < n / 2; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 10, 2, 3, 5, 6})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 1, 6, 2, 2, 7, 3, 14})));
        System.out.println(Arrays.toString(T.solution(new int[]{14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14})));
    }
}
