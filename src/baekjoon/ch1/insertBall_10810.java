package baekjoon.ch1;

import java.util.Scanner;

public class insertBall_10810 {

    public void logic() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int A[] = new int[n+1];
        for(int i = 0; i < m; i++){
            int a, b, c;
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            for(int j = a; j <= b; j++){
                A[j] = c;
            }
        }
        for(int i = 1; i < n + 1; i++){
            System.out.print(A[i] + " ");
        }
    }
}
