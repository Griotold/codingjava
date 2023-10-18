package kim.ch8_DFS_BFS_plus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 동전교환_5 {
    static int n, m, answer=Integer.MAX_VALUE;
    static Integer[] arr;
    /**
     * 내 풀이 - DFS를 두 번 호출할 필요가 없었다.
     * */
    public void DFS(int L, int sum) {
        if(sum > m) return;
        if(sum == m) {
            answer = Math.min(answer, L);
        }
        else {
            for(int i = 0 ; i < n; i++) {
                DFS(L + 1, sum + arr[i]);
                DFS(L + 1, sum);
            }
        }
    }
    public void DFSByTeacher(int L, int sum) {
        if(sum > m) return;
        if(L>=answer) return; // 더 많은 동전을 사용하는 것은 깊게 들어갈 필요가 없다.
        if(sum == m) {
            answer = Math.min(answer, L);
        } else {
            for(int i = 0; i < n; i++){
                DFS(L + 1, sum + arr[i]);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        동전교환_5 T = new 동전교환_5();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new Integer[n];
        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr, Collections.reverseOrder());
        m = Integer.parseInt(br.readLine());
        T.DFS(0, 0);
        System.out.println(answer);
        br.close();
    }
}
