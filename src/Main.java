import java.io.*;
import java.util.*;


public class Main {
    // 11 -> 1011
    public void sol(int N) {
        if(N == 1) {
            System.out.print(N);
//            return;
        } else {
            int rest = N % 2;
            int quotient = N / 2;
            sol(quotient);
            System.out.print(rest);
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