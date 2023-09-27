import java.io.*;
import java.util.*;
public class Main {
    /**
     * 5
     * 10 13 10 12 15
     * 12 39 30 23 11
     * 11 25 50 53 15
     * 19 27 29 37 27
     * 19 13 30 13 19
     * */
    static int[][] map;
    public int solution(int N, int[][] arr) {
        int answer = 0;
        // 행
        for(int i = 0; i < N; i++) {
            int tmp = 0;
            for(int j = 0; j < N; j++) {
                tmp += map[i][j];
            }
            if(tmp > answer) answer = tmp;
        }
        // 열
        for(int i = 0; i < N; i++) {
            int tmp = 0;
            for(int j = 0; j < N; j++) {
                tmp += map[j][i];
            }
            if(tmp > answer) answer = tmp;
        }
        int tmp = 0;
        for(int i = 0; i < N; i++) {
            tmp += map[i][i];
        }
        if(tmp > answer) answer = tmp;

        tmp = 0;
        for(int i = 0; i < N; i++) {
            tmp += map[i][N-i-1];
        }
        if(tmp > answer) answer = tmp;
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(T.solution(N, map));
        br.close();
    }
}