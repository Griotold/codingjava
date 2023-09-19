package baekjoon.ch1;

import java.util.Scanner;

public class Avg_1546 {

    public void logic() {
        // 3
        // 40 80 60
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A[] = new int[N];
        for(int i = 0; i < N; i++){
            A[i] = sc.nextInt();
        }
        int m = -100;
        for (int i = 0; i < N; i++) {
            if(A[i] > m) m = A[i];
        }
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += A[i];
        }
        System.out.println(sum*100.0/ m /N);
    }
}
