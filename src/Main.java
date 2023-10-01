import java.io.*;
import java.util.*;
public class Main {
    public int solution(int N) {
        int answer = 0, sum;
        for(int i = 2; i < N; i++) {
            sum = 0;
            for(int j = 1; j <= i; j++) {
                sum += j;
            }
            if(N >= sum && (N - sum) % i == 0) answer++;
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(T.solution(N));

        br.close();
    }
}