import kim.string.문자찾기_1;

import java.util.*;
import java.io.*;
/**
 * 한개의 문자열을 입력받고, 특정 문자를 입력받아 해당 특정문자가 입력받은 문자열에
 * 몇 개 존재하는지 알아내는 프로그램을 작성해라
 * 대소문자 구분 안함. 문자열의 길이는 100이하
 * Computercooler
 * c
 * */
public class Main {

    public int solution(String str, char c) {
        int answer = 0;

        // 1. 모두 소문자로 변환
        String lowerCase = str.toLowerCase();

        // 2. 해쉬 맵
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char key = lowerCase.charAt(i);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        // 3. 키 값을 넣었을 때 몇 개 있는지 리턴
        answer = map.get(c);
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        문자찾기_1 문자찾기_1 = new 문자찾기_1();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        char c = br.readLine().charAt(0);
        System.out.println(main.solution(str, c));
        System.out.println(문자찾기_1.solution(str, c));
        br.close();
        bw.close();
    }
}