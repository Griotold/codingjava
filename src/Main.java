import java.io.*;
import java.util.*;


public class Main {
    // 5 --> 120
    public int sol(int N) {
        if(N == 1) {
            return 1;
        } else{
            return N * sol(N - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(T.sol(N));
        br.close();
    }
}