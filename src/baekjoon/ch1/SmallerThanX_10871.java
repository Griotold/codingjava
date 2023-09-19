package baekjoon.ch1;

import java.util.Scanner;

public class SmallerThanX_10871 {

    public void logic() {
        // 10 5
        // 1 10 4 9 2 3 8 5 7 6
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int X = sc.nextInt();
        for (int i = 0; i < N; i++){
            int a = sc.nextInt();
            if(a < X) System.out.print(a + " ");
        }
    }
}
