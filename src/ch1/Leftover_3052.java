package ch1;

import java.util.Scanner;

public class Leftover_3052 {

    public void logic() {
        Scanner sc = new Scanner(System.in);
        int A[] = new int[43];
        for(int i = 0; i < 10; i++){
            int tmp = sc.nextInt();
            A[tmp % 42]++;
        }
        int cnt = 0;
        for(int i = 0; i <= 41; i++){
            if(A[i] != 0) cnt++;
        }
        System.out.println(cnt);
    }
}
