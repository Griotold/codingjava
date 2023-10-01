import java.io.*;
import java.util.*;
public class Main {
    public int solution(int N) {
        int answer = 0, sum = 0, lt = 1;
        for(int rt = 1; rt < N; rt++) {
            sum += rt;
            if(sum == N) answer++;
            while(sum >= N) {
                sum -= lt++;
                if(sum == N) answer++;
            }
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