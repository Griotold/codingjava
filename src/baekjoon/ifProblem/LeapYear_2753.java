package baekjoon.ifProblem;

import java.util.Scanner;

public class LeapYear_2753 {

    public void logic() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        if (a % 4 == 0) {
            if(a % 100 != 0 || a % 400 == 0) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        } else {
            System.out.println("0");
        }
    }
}
