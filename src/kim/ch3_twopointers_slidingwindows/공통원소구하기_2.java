package kim.ch3_twopointers_slidingwindows;

import java.util.ArrayList;
import java.util.Arrays;

public class 공통원소구하기_2 {
        public ArrayList<Integer> solution(int N, int M, int[] a, int[] b) {
            ArrayList<Integer> answer = new ArrayList<>();
            // 1. 정렬부터
            Arrays.sort(a);
            Arrays.sort(b);

            // 2. 공통된 것 찾아보기
            int p1 = 0, p2 = 0;
            while(p1 < N && p2 < M) {
                if(a[p1] == b[p2]) {
                    answer.add(a[p1]);
                    p1++;
                    p2++;
                }
                else if(a[p1] < b[p2]) p1++;
                else p2++;
            }
            return answer;
        }
    }
}
