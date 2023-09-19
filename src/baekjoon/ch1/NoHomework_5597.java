package baekjoon.ch1;

import java.util.Scanner;

public class NoHomework_5597 {

    public void logic() {
        Scanner sc = new Scanner(System.in);
        int A[] = new int[31];
        for(int i = 0; i < 28; i++){
            int tmp = sc.nextInt();
            A[tmp]++;
        }
        for (int i = 1; i <= 30; i++) {
            if (A[i] == 0) System.out.println(i);
        }
    }
}
