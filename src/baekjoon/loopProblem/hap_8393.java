package baekjoon.loopProblem;

import java.util.Scanner;

public class hap_8393 {

    public void logic() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ret = 0;
        for(int i = 1; i <= n; i++){
            ret += i;
        }
        System.out.println(ret);
    }
}
