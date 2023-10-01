import java.io.*;
import java.util.*;
public class Main {
    // 10 3
    // 12 15 11 20 25 10 20 19 13 15 --> 56
    public int solution(int N, int K, int[] arr) {
        int answer = 0, sum = 0;
        for(int i = 0; i < K; i++) {
            sum += arr[i];
        }
        answer = sum;
        for(int i = K; i < N; i++){
            sum += arr[i];
            sum -= arr[i - K];
            answer = Math.max(answer, sum);
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(T.solution(N, K, arr));

        br.close();
    }
}