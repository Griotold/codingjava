package baekjoon.string;

import java.io.*;

public class 알파벳찾기_10809 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        // 카운팅 배열 전부 -1로 초기화
        int[] countingArr = new int[30];
        for(int i = 0; i < countingArr.length; i++) {
            countingArr[i] = -1;
        }
        int count = 0;
        for(int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 97;
            if(countingArr[index] == -1) {
                countingArr[index] = count;
            }
            count++;
        }
        for (int i = 0; i < 26; i++) {
            System.out.print(countingArr[i] + " ");
        }

        br.close();
        bw.close();
    }
}
