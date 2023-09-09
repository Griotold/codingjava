package programmers;

import java.util.HashMap;
/**
 * 내 풀이
 * */
public class 의상_1 {

    public int solution(String[][] clothes) {
        // 1. 옷을 종류 별로 구분한다.
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 1) + 1);
        }
//        System.out.println(map);

        // 2. 입지 않는 경우를 추가해서 모든 조합을 계산한다.
        int answer = 1;
        for(String key : map.keySet()) {
            answer = answer * map.get(key);
        }

        // 3. 아무 종류의 옷도 입지 않는 경우 제외한다.
        answer--;

        return answer;
    }
}
