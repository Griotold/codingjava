package baekjoon.string;

import java.io.*;

public class 문자열_9086 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            String str = br.readLine();
            int len = str.length();
            String answer = "";
            answer += str.charAt(0);
            answer += str.charAt(len - 1);

            bw.write(answer);
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
