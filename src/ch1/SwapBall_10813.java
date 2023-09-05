package ch1;

import java.util.Scanner;

public class SwapBall_10813 {

    public void logic() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int A[] = new int[n+1];
        for(int i = 1; i <= n; i++){
            A[i] = i;
        }
        for(int i = 0; i < m; i++){
            int a, b, tmp;
            a = sc.nextInt();
            b = sc.nextInt();
            tmp = A[a];
            A[a] = A[b];
            A[b] = tmp;
        }
        for(int i = 1; i <= n; i++){
            System.out.print(A[i] + " ");
        }
    }
}
