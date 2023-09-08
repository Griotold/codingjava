package programmers;

import java.util.Arrays;
/**
 * 정렬 & 반복문
 * */
public class 전화번호목록_1 {

    public boolean solution(String[] phone_book) {
        // 1. phone_book 정렬
        Arrays.sort(phone_book);

        // 2. 앞번호가 뒷번호의 접두어인지 확인
        for(int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }
        // 3. 접두어가 없다
        return true;
    }
}
