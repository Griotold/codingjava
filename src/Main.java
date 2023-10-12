import java.io.*;
import java.util.*;


public class Main {
    // 3 -> 1 2 3
    public void sol(int N) {
        if(N == 1) {
            System.out.print(N + " ");
            return;
        } else {
            sol(N - 1);
            System.out.print(N + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        T.sol(N);
        br.close();
    }
}