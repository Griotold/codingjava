package baekjoon.ch1;

import java.util.Scanner;

public class RevertBasket_10811 {

    public static void logic() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int A[] = new int[n + 1];
        for(int i = 1; i <= n; i++){
            A[i] = i;
        }
        for(int i = 0; i < m; i++){
            int a, b;
            a = sc.nextInt();
            b = sc.nextInt();
            for(int j = a; j <= b ; j++){
                int nn = b--;

                int tmp = A[j];
                A[j] = A[nn];
                A[nn] = tmp;
            }
        }
        for(int i = 1; i <= n; i++){
            System.out.print(A[i] + " ");
        }
    }
}
