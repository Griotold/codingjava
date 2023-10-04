import java.io.*;
import java.util.*;
public class Main {
    // 10 3
    // 13 15 34 23 45 65 33 11 26 42 --> 143
    public int solution(int N, int K, int[] arr) {
        int answer = -1;
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        for(int i = 0; i < N; i++) {
            for(int j = i + 1; j < N; j++) {
                for(int s = j + 1; s < N; s++) {
                    set.add(arr[i] + arr[j] + arr[s]);
                }
            }
        }
        int cnt = 0;
        for(int x : set) {
            cnt++;
            if(cnt == K) return x;
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