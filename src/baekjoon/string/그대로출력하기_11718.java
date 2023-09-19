package baekjoon.string;

import java.io.*;

public class 그대로출력하기_11718 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = "";

        while ((str = br.readLine()) != null) {
            bw.write(str);
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
