package kim.ch4_hash;

import java.util.HashMap;

public class 학급회장_1 {
    /**
     * 내 풀이
     * */
    public char solution(int N, String str) {
        char answer = 0;
        int max = Integer.MIN_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for(char key: map.keySet()) {
            if(map.get(key) > max){
                max = map.get(key);
                answer = key;
            }
        }
        return answer;
    }

    /**
     * 강사님 풀이
     */
    public char solution2(int n, String s) {
        char answer = ' ';
        HashMap<Character, Integer> map = new HashMap<>();
        for (char x : s.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        int max = Integer.MIN_VALUE;
        for (Character key : map.keySet()) {
//            System.out.println(key + " "+ map.get(key));
            if(map.get(key) > max) {
                max = map.get(key);
                answer = key;
            }
        }
        return answer;
    }
}
