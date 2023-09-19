package baekjoon.hash;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 듣보잡_1764 {
    public static void logic(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 1. Hash에 듣지 못한 사람 반영
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++){
            String key = br.readLine();
            map.put(key, 1);
        }

        // 2. Hash에 보지 못한 사람이 존재하는지 확인 -> ArrayList에 담기
        ArrayList<String> answer = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String key = br.readLine();
            if(map.containsKey(key)) {
                answer.add(key);
            }
        }

        // 3. 정렬후 출력
        Collections.sort(answer);

        bw.write(String.valueOf(answer.size()));
        bw.newLine();
        for (String str : answer) {
            bw.write(str);
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
