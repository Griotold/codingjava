import java.io.*;
import java.util.*;
public class Main {
    /**
     * 5
     * 5 3 7 2 3
     * 3 7 1 6 1
     * 7 2 5 3 4
     * 4 3 6 4 1
     * 8 7 3 5 2
     * */
    public int solution(int N, int[][] arr) {
       int answer = 0;
       for(int i = 1; i <= N; i++) {
           for(int j = 1; j <= N; j++) {
               int now = arr[i][j];
               if(now > arr[i][j+1] && now > arr[i+1][j] && now > arr[i-1][j] && now > arr[i][j-1])
                   answer++;
           }
       }
       return answer;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N + 2][N + 2];
        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(T.solution(N, map));
        br.close();
    }
}