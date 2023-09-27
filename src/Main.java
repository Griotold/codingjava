import java.io.*;
import java.util.*;
public class Main {
    public int[] solution(int N) {
        int[] answer = new int[N];
        answer[0] = 1;
        answer[1] = 1;
        for(int i = 2; i < N; i++) {
            answer[i] = answer[i - 2] + answer[i - 1];
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int x : T.solution(N)) {
            System.out.print(x + " ");
        }
        br.close();
    }
}