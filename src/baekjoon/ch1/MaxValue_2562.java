package baekjoon.ch1;

import java.util.Scanner;

public class MaxValue_2562 {

    public void logic() {
        Scanner sc = new Scanner(System.in);
        int max = 0;
        int maxIndex = 0;
        int a[] = new int[9];
        for(int i = 0; i < 9; i++){
            a[i] = sc.nextInt();
            if(max < a[i]) {
                max = a[i];
                maxIndex = i;
            }
        }
        System.out.println(max);
        System.out.println(maxIndex + 1);
    }
}
