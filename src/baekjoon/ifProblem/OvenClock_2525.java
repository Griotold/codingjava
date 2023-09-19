package baekjoon.ifProblem;

import java.util.Scanner;

public class OvenClock_2525 {

    public void logic() {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int m = sc.nextInt();
        int needTime = sc.nextInt();

        // 입력된 시간과 분을 분 단위로 변환합니다.
        int totalMinutes = h * 60 + m;

        // 필요한 시간을 더합니다.
        totalMinutes += needTime;

        // 24시간 형식으로 출력합니다.
        int newH = (totalMinutes / 60) % 24;
        int newM = totalMinutes % 60;

        System.out.printf("%d %d", newH, newM);
    }
}
