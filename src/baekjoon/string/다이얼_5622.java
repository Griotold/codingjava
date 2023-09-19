package baekjoon.string;

import java.io.*;

public class 다이얼_5622 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // WA
        String str = br.readLine();
        int count = 0;
        for(int i = 0; i < str.length(); i++) {
            char value = str.charAt(i);
            if(value < 68) count += 3;
            else if(value < 71) count += 4;
            else if(value < 74) count += 5;
            else if(value < 77) count += 6;
            else if(value < 80) count += 7;
            else if(value < 84) count += 8;
            else if(value < 87) count += 9;
            else count += 10;
        }
        bw.write(String.valueOf(count));

        br.close();
        bw.close();
    }
}
