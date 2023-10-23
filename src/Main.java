import java.io.*;
import java.util.*;

public class Main {
    // 9 7
    //1 2
    //2 3
    //3 4
    //1 5
    //6 7
    //7 8
    //8 9
    //3 8 --> NO
    static int[] unf;

    public static int find(int v) {
        if(v == unf[v]) return v;
        else return unf[v] = find(unf[v]);
    }
    public static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if(fa != fb) unf[fa] = fb;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        unf = new int[N + 1];
        for (int i = 1; i <= N; i++) unf[i] = i;
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int fa = find(a);
        int fb = find(b);
        if(fa == fb) System.out.println("YES");
        else System.out.println("NO");
        br.close();
    }
}