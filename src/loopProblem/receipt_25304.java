package loopProblem;

import java.util.Scanner;

public class receipt_25304 {

    public void logic() {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();
        int sum = 0;
        for(int i = 0; i < n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            sum += (a*b);
        }
        if(x == sum){
            System.out.println("Yes\n");
        } else {
            System.out.println("No\n");
        }
    }
}
