package loopProblem;

import java.util.Scanner;

public class gugudan_2739 {

    public void logic() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 1; i <= 9; i++){
            System.out.printf("%d * %d = %d\n", n, i, n*i);
        }
    }
}
