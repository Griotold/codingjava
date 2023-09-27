import java.io.*;
import java.util.*;
public class Main {
//    5
//    2 3 3 1 3
//    1 1 2 2 3
    public char[] solution(int N, int[] aArr, int[] bArr) {
        char[] answer = new char[N];
        for(int i = 0; i < N; i++) {
            int a = aArr[i];
            int b = bArr[i];
            if (a == b) {
                answer[i] = 'D';
            } else {
                if(a == 1) {
                    if(b == 2) answer[i] = 'B';
                    else answer[i] = 'A';
                } else if(a == 2) {
                    if(b == 1) answer[i] = 'A';
                    else answer[i] = 'B';
                } else {
                    if (b == 1) answer[i] = 'B';
                    else answer[i] = 'A';
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] aArr = new int[N];
        for(int i = 0; i < N; i++) {
            aArr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int[] bArr = new int[N];
        for(int i = 0; i < N; i++) {
            bArr[i] = Integer.parseInt(st.nextToken());
        }

        for(char x : T.solution(N, aArr, bArr)) {
            System.out.println(x);
        }
        br.close();
    }
}