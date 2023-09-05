package ch1;

import java.util.Scanner;

public class CountNumber_10807 {

    public void logic() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int a[] = new int[N];
        for(int i = 0; i < N; i++){
            a[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        int cnt = 0;
        for (int i : a) {
            if(target == i) cnt++;
        }
        System.out.println(cnt);
    }
}
