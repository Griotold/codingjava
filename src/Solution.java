import java.util.*;

class Solution {
    public int[] solution(String s){
        int[] answer = new int[5];
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        for (int value : map.values()) {
            max = Math.max(max, value);
        }
        for (int i = 0; i < 5; i++) {
            char key = (char) ('a' + i);
            answer[i] = max - map.getOrDefault(key, 0);
        }
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution("aaabc")));
        System.out.println(Arrays.toString(T.solution("aabb")));
        System.out.println(Arrays.toString(T.solution("abcde")));
        System.out.println(Arrays.toString(T.solution("abcdeabc")));
        System.out.println(Arrays.toString(T.solution("abbccddee")));
    }

}
