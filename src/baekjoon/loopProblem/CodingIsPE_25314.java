package baekjoon.loopProblem;

import java.util.Scanner;

public class CodingIsPE_25314 {

    public void logic() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = n / 4;
        for(int i = 1; i <= cnt; i++){
            System.out.print("long ");
        }
        System.out.println("int");
    }
}
