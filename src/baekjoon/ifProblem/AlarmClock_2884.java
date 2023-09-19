package baekjoon.ifProblem;

import java.util.Scanner;

public class AlarmClock_2884 {

    public void logic() {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int m = sc.nextInt();

        if(h == 0) {
            if(m < 45) {
                int rest = 45 - m;
                int actual = 60 - rest;
                System.out.println("23 " + actual);
            } else {
                int actual = m - 45;
                System.out.println("0 " + actual);
            }
        } else {
            if(m < 45) {
                int rest = 45 - m;
                int actual = 60 - rest;
                int actualHour = h - 1;
                System.out.println(actualHour + " " + actual);
            } else {
                int actual = m - 45;
                System.out.println(h + " " + actual );
            }
        }
    }
}
