package kim.ch4_hash;

import java.util.HashMap;

public class 모든아나그램찾기_4 {
    public int solution(String str1, String str2) {
        int answer = 0;
        int len1 = str1.length();
        int len2 = str2.length(); // 3
        HashMap<Character, Integer> str1Map = new HashMap<>();
        HashMap<Character, Integer> str2Map = new HashMap<>();

        // 1. str2Map 부터 초기화
        for(int i = 0; i < len2; i++) {
            char ch = str2.charAt(i);
            str2Map.put(ch, str2Map.getOrDefault(ch, 0) + 1);
        }

        // 2. str1Map을 Sliding window 돌리기 직전으로 세팅
        for(int i = 0; i < len2 - 1; i++) {
            char ch = str1.charAt(i);
            str1Map.put(ch, str1Map.getOrDefault(ch, 0) + 1);
        }

        // 3.
        int lt = 0;
        for(int rt = len2 - 1; rt < len1; rt++) {
            char ch = str1.charAt(rt);
            str1Map.put(ch, str1Map.getOrDefault(ch, 0) + 1);
            // str1Map 과 str2Map이 같니?
            if(str1Map.equals(str2Map)) answer++;
            char pre = str1.charAt(lt);
            str1Map.put(pre, str1Map.get(pre) - 1);
            if(str1Map.get(pre) == 0) str1Map.remove(pre);
            lt++;
        }
        return answer;
    }
}
