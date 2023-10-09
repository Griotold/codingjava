import java.io.*;
import java.util.*;
public class Main {
    // 8
    // 20 25 52 30 39 33 43 33 --> D
    public String sol(int N, int[] arr) {
        // 1. TreeSet에 넣고
        TreeSet<Integer> set = new TreeSet<>();
        for (int x : arr) set.add(x);
        // 크기가 배열보다 작으면 D
        if (set.size() == arr.length) return "U";
        else return "D";
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        System.out.println(T.sol(N, arr));
        br.close();
    }
}