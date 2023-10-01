import java.io.*;
import java.util.*;
public class Main {
    // 8 6
    // 1 2 1 3 1 1 1 2  --> 3
    public int solution(int N, int M, int[] arr) {
        int answer = 0, sum = 0, lt = 0;
        for(int rt = 0; rt < N; rt++){
            sum += arr[rt];
            if(sum == M) answer++;
            while(sum >= M) {
                sum -= arr[lt++];
                if(sum == M) answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(T.solution(N, M, arr));

        br.close();
    }
}