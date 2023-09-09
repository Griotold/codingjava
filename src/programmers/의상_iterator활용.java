package programmers;

import java.util.HashMap;
import java.util.Iterator;

public class 의상_iterator활용 {

    public int solution(String[][] clothes) {
        // 1. 옷을 종류 별로 구분한다.
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] clothe : clothes) {
            String type = clothe[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }

        // 2. 입지 않는 경우를 추가해서 모든 조합을 계산한다.
        int answer = 1;
        Iterator<Integer> it = map.values().iterator();
        while(it.hasNext())
            answer *= it.next().intValue() + 1;

        // 3. 아무 종류의 옷도 입지 않는 경우 제외한다.
        return answer - 1;
    }
}
