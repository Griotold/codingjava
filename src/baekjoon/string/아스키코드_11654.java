package baekjoon.string;

import java.io.*;

public class 아스키코드_11654 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        char ch = s.charAt(0);
        int ascii = ch;
        bw.write(String.valueOf(ascii));

        br.close();
        bw.close();
    }
}
