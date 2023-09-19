package baekjoon.string;

import java.io.*;

/**
 * 단어 S와 정수 i가 주어졌을 때, S의 i번째 글자를 출력
 * 하는 프로그램 작성
 * */
public class 문자와문자열_27866 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        int i = Integer.parseInt(br.readLine());
        char ch = s.charAt(i - 1);
        bw.write(ch);

        br.close();
        bw.close();
    }
}
