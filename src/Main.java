import java.io.*;
import java.util.*;
public class Main {
    /**
     * 자연수 N이 입력되면 1부터 N까지 수 중
     * M의 배수들의 합을 출력하는 프로그램
     * 입력 : 15 3
     * 출력 : 45
     * */
    public int solution(int N, int M) {
        int answer = 0;
        // 1. N까지 반복문을 돌다가 배수라면 answer에 더한다
        for(int i = 1; i <= N; i++){
            if (i % M == 0) answer += i;
        }

        // 2. answer 출력

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Main main = new Main();
        System.out.println(main.solution(N, M));
        br.close();
        bw.close();
    }
}