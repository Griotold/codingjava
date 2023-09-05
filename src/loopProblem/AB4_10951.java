package loopProblem;

import java.io.*;
import java.util.StringTokenizer;

public class AB4_10951 {

    public void logic() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String line = br.readLine();
            if (line == null || line.equals("")) {
                // 입력이 더 이상 없거나 빈 줄인 경우 종료
                break;
            }

            StringTokenizer st = new StringTokenizer(line);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int sum = a + b;
            bw.write(Integer.toString(sum));
            bw.newLine(); // 줄 바꿈 문자를 추가하여 다음 줄로 넘어갑니다.
        }

        bw.close();
    }
}
