import java.io.*;
import java.util.*;
public class Main {
    public int solution(int N, int M, int[][] arr) {
        int answer = 0;
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++) {
                int cnt = 0;
                for(int k = 0; k < M; k++) {
                    int pi = 0, pj = 0;
                    for(int s = 0; s < N; s++) {
                        if(arr[k][s] == i) pi = s;
                        if(arr[k][s] == j) pj = s;
                    }
                    if(pi < pj) cnt++;
                }
                if (cnt == M) answer++;
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
        int[][] arr = new int[M][N];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(T.solution(N, M, arr));
        br.close();
    }
}