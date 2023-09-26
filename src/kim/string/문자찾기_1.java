package kim.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

/**
 * 한개의 문자열을 입력받고, 특정 문자를 입력받아 해당 특정문자가 입력받은 문자열에
 * 몇 개 존재하는지 알아내는 프로그램을 작성해라
 * 대소문자 구분 안함. 문자열의 길이는 100이하
 * Computercooler
 * c
 * */
public class 문자찾기_1 {

    public int solution(String str, char c) {
        int answer = 0;

        // 1. 소문자로 변환
        str = str.toLowerCase();
        c = Character.toLowerCase(c);

        // 2. 반복문 -> c와 일치한다면 answer를 증가
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == c) answer++;
        }

        // 3. return 증가

        return answer;
    }
}
