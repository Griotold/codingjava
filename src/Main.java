import java.io.*;
import java.util.*;
public class Main {
    // 5
    //1 3 9 5 2
    //5
    //3 2 5 7 8

    public ArrayList<Integer> solution(int N, int M, int[] a, int[] b) {
        ArrayList<Integer> answer = new ArrayList<>();
        // 1. 정렬부터
        Arrays.sort(a);
        Arrays.sort(b);

        // 2. 공통된 것 찾아보기
        int p1 = 0, p2 = 0;
        while(p1 < N && p2 < M) {
            if(a[p1] == b[p2]) {
                answer.add(a[p1]);
                p1++;
                p2++;
            }
            else if(a[p1] < b[p2]) p1++;
            else p2++;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        int[] b = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        for(int x : T.solution(N, M, a, b)) {
            System.out.print(x + " ");
        }

        br.close();
    }
}