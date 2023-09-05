package ifProblem;

import java.util.Scanner;

public class ThreeDices_2480 {

    public void logic() {
        Scanner sc = new Scanner(System.in);
        int[] cnt = new int[7];
        int maxCnt = 0;
        int maxIdx = 0;
        int result = 0;

        for(int i = 0; i < 3; i++){
            int tmp = sc.nextInt();
            cnt[tmp]++;
        }

        for(int i = 1; i <= 6; i++){
            if(cnt[i] == 0) continue;
            if(cnt[i] >= maxCnt) {
                maxIdx = i;
                maxCnt = cnt[i];
            }
        }

        if (cnt[maxIdx] == 3) {
            result = 10000 + maxIdx * 1000;
        } else if (cnt[maxIdx] == 2) {
            result = 1000 + maxIdx * 100;
        } else {
            result = maxIdx * 100;
        }

        System.out.println(result);
    }
}
