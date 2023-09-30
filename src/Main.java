import java.io.*;
import java.util.*;
public class Main {
    // 5
    //2 3 1 7 3
    //4 1 9 6 8
    //5 5 2 4 4              -> 4
    //6 5 2 6 7
    //8 4 2 2 2
    public int solution(int N, int[][] arr) {
        int answer = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= N; i++) {
            int count = 0;
            for(int j = 1; j <= N; j++) {
                if(i == j )continue;
                for(int k = 1; k <= 5; k++) {
                    if(arr[i][k] == arr[j][k]) {
                        count++;
                        break;
                    }
                }
            }
            if(count > max) {
                max = count;
                answer = i;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N+1][5+1];
        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(T.solution(N, arr));
        br.close();
    }
}