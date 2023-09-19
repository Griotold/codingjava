package baekjoon.ch1;

import java.util.Scanner;

public class Min_Max_10818 {

    public void logic() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int min = 1000000;
        int max = -1000000;
        for(int i = 0; i < n; i++){
            int tmp = sc.nextInt();
            if(tmp > max) max = tmp;
            if(tmp < min) min = tmp;
        }
        System.out.print(min + " ");
        System.out.println(max);
    }
}
