import java.io.*;
import java.util.*;
public class Main {
//    3
//    1 3 5
//    5
//    2 3 6 7 9
    public int[] solution(int N, int M, int[] arr1, int[] arr2) {
        int[] answer = new int[N + M];
        int lt = 0, rt = 0, index = 0;
        while(true) {
            if(arr1[lt] > arr2[rt]) {
                answer[index++] = arr2[rt++];
            } else if(arr1[lt] < arr2[rt]) {
                answer[index++] = arr1[lt++];
            } else {
                answer[index++] = arr2[rt++];
                answer[index++] = arr1[lt++];
            }
            if(lt == N || rt == M ) break;
        }
        for(int i = lt; i < N; i++) {
            answer[index++] = arr1[i];
        }
        for(int j = rt; j < M; j++) {
            answer[index++] = arr2[j];
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr1 = new int[N];
        for(int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr2 = new int[M];
        for(int i = 0; i < M; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        for (int x : T.solution(N, M, arr1, arr2)) {
            System.out.print(x + " ");
        }
        br.close();
    }
}