package baekjoon.string;

import java.io.*;

public class 단어길이재기_2743 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        bw.write(String.valueOf(s.length()));
        br.close();
        bw.close();
    }
}
