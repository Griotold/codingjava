import java.io.*;
import java.util.*;
public class Main {
    public int solution(int N) {
        int answer = 0;
        for(int i = 2; i <= N; i++){
            for(int j = 2; j * j <= i; j++) {
                if(i % j == 0) {
                    answer++;
                    break;
                }
            }
        }
        answer++;
        return N - answer;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(T.solution(N));
        br.close();
    }
}