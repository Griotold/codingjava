package baekjoon.string;

import java.io.*;
import java.util.StringTokenizer;

public class 단어의개수_1152 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        System.out.print(st.countTokens());

        br.close();
        bw.close();
    }
}
