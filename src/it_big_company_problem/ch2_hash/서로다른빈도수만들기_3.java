package it_big_company_problem.ch2_hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class 서로다른빈도수만들기_3 {

    /**
     * 정답
     */
    public int solByTeacher(String s) {
        int answer = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        HashSet<Integer> ch = new HashSet<>();

        // 1. 해싱
        for (char x : s.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        // 2. 유니크한 빈도수 집합이 되도록 빈도수를 제거
        for (char key : map.keySet()) {
            while (ch.contains(map.get(key))) {
                answer++;
                map.put(key, map.get(key) - 1);
            }
            if (map.get(key) == 0) continue;
            ch.add(map.get(key));
        }
        return answer;
    }
    /**
     * 내 풀이
     * */
    public int solution(String s){
        int answer = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        Set<Integer> countSet = new HashSet<Integer>();
        for (char key : map.keySet()) {
            while (map.get(key) > 0) {
                if (countSet.contains(map.get(key))) {
                    map.put(key, map.get(key) - 1);
                    answer++;
                } else {
                    countSet.add(map.get(key));
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args){
        서로다른빈도수만들기_3 T = new 서로다른빈도수만들기_3();
        System.out.println(T.solution("aaabbbcc"));
        System.out.println(T.solution("aaabbc"));
        System.out.println(T.solution("aebbbbc"));
        System.out.println(T.solution("aaabbbcccde"));
        System.out.println(T.solution("aaabbbcccdddeeeeeff"));
    }
}
