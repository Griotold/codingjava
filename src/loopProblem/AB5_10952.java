package loopProblem;

import java.io.*;
import java.util.StringTokenizer;

public class AB5_10952 {

    public void logic() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a == 0 && b == 0) break;
            String result = Integer.toString(a + b); // 합계를 문자열로 변환하여 출력
            bw.write(result);
            bw.newLine();
        }
        bw.close();
    }
}
