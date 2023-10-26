package it_big_company_problem.ch2_hash;

import java.util.HashMap;

public class 한번사용한최초문자_1 {
    /**
     * 내 풀이 - 최초를 보장하지 않는 풀이 : Map은 순서를 보장하지 않는다
     *        - 불완전한 코드
     * */
    public int solution(String s){
        int answer = -1;
        HashMap<Character, Integer> map = new HashMap<>();
        // 1. 해시
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // 2. 1개만 쓰인거 찾기
        char target = 0;
        for (char key : map.keySet()) {
            if(map.get(key) == 1) {
                target = key;
                answer = s.indexOf(target) + 1;
                break;
            }
        }
        return answer;
    }
    /**
     * 강사님 풀이 - 최초로 등장한 것을 리턴하도록 보완
     * */
    public int solByTeacher(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        for (char x : s.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        // 최초로 등장한 것을 리턴하도록 보장
        for (int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i)) == 1) return i + 1;
        }
        // 한 번만 쓴게 없다면 -1을 리턴
        return -1;
    }

    public static void main(String[] args){
        한번사용한최초문자_1 T = new 한번사용한최초문자_1();
        System.out.println(T.solution("statitsics"));
        System.out.println(T.solution("aabb"));
        System.out.println(T.solution("stringshowtime"));
        System.out.println(T.solution("abcdeabcdfg"));
    }
}
