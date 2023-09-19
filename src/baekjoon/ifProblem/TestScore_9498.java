package baekjoon.ifProblem;

import java.util.Scanner;

public class TestScore_9498 {

    public void logic() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        if (a >= 90) {
            System.out.println("A");
        } else if (a >= 80) {
            System.out.println("B");
        } else if (a >= 70) {
            System.out.println("C");
        } else if (a >= 60) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }
    }
}
