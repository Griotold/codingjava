import java.io.*;
import java.util.*;
public class Main {
    // 14 2
    // 1 1 0 0 1 1 0 1 1 0 1 1 0 1 -> 8
    public int solution(int N, int M, int[] arr) {
        int answer = 0, cnt = 0, sum = 0, lt = 0;
        for(int rt = 0; rt < N; rt++) {
            if(arr[rt] == 0) cnt++;
            while(cnt > M) {
                if(arr[lt] == 0) {
                    cnt--;
                }
                lt++;
            }
            sum = rt - lt + 1;
            answer = Math.max(answer, sum);
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