package it_big_company_problem.ch2_hash;

import java.util.Arrays;
import java.util.HashMap;

public class 같은빈도수만들기_2 {

    /**
     * 정답
     */
    public int[] solByTeacher(String s) {
        int[] answer = new int[5];
        HashMap<Character, Integer> map = new HashMap<>();

        // 1. 해싱
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // 2. 최댓값 찾기
        int max = Integer.MIN_VALUE;
        String temp = "abcde";
        for (char key : temp.toCharArray()) {
            if (map.getOrDefault(key, 0) > max) {
                max = map.getOrDefault(key, 0);
            }
        }

        // answer 만들기
        for (int i = 0; i < 5; i++) {
            char ch = temp.charAt(i);
            answer[i] = max - map.getOrDefault(ch, 0);
        }

        return answer;
    }

    /**
     * 내 풀이
     * */
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
        같은빈도수만들기_2 T = new 같은빈도수만들기_2();
        System.out.println(Arrays.toString(T.solution("aaabc")));
        System.out.println(Arrays.toString(T.solution("aabb")));
        System.out.println(Arrays.toString(T.solution("abcde")));
        System.out.println(Arrays.toString(T.solution("abcdeabc")));
        System.out.println(Arrays.toString(T.solution("abbccddee")));
    }
}
