package baekjoon.loopProblem;

import java.util.Scanner;

public class star1_2438 {

    public void logic() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
