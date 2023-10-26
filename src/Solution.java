import java.util.*;

class Solution {
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

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution("statitsics"));
        System.out.println(T.solution("aabb"));
        System.out.println(T.solution("stringshowtime"));
        System.out.println(T.solution("abcdeabcdfg"));
    }
}
