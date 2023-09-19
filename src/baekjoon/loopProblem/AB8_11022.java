package baekjoon.loopProblem;

import java.io.*;
import java.util.StringTokenizer;

public class AB8_11022 {

    public void logic() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t  = Integer.parseInt(br.readLine());
        for(int i = 1; i <= t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            String formatted = String.format("Case #%d: %d + %d = %d\n", i, a, b, a + b);
            bw.write(formatted);
        }

        bw.close();
    }
}
