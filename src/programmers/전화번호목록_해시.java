package programmers;

import java.util.HashMap;

public class 전화번호목록_해시 {
    public boolean solution(String[] phone_book) {
        // 1. HashMap을 만든다
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], 1);
        }

        // 2. 모든 전화번호의 접두어가 HashMap에 있는지 확인한다.
        for(int i = 0; i < phone_book.length; i++) {
            for (int j = 1; j < phone_book[i].length(); j++) {
                if (map.containsKey(phone_book[i].substring(0, j)));
                return false;
            }
        }
        // 3. 여기까지 왔다면 접두어가 없다는 거다.
        return true;
    }
}
