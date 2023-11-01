package it_big_company_problem.ch1_simulation;

import java.util.Arrays;
/**
 * 반은 맞고 반은 틀림
 * */
public class 과일가져가기_6 {
    public boolean isMinUnique(int[] arr) {
        int mini = Integer.MAX_VALUE;
        boolean flag = true;
        for(int x : arr) {
            if(x == mini) {
                flag = false;
                break;
            }
            mini = Math.min(mini, x);
        }
        return flag;
    }
    public int minIndex(int[] arr) {
        int mini = Integer.MAX_VALUE;
        int idx = -1;
        for(int i = 0; i < arr.length; i++) {
            if(mini > arr[i]) {
                mini = arr[i];
                idx = i;
            }
        }
        return idx;
    }
    public int solution(int[][] fruit){
        int answer = 0;
        int n = fruit.length;
        int[] ch = new int[n];
        for(int i = 0; i < n; i++) {
            // 0. 교환한 적이 있는 학생인가?
            if(ch[i] == 1) continue;

            // 1. 최솟값이 유니크한가?
            if(!isMinUnique(fruit[i])) continue;
            int outerMinIdx = minIndex(fruit[i]);
            for(int j = i + 1; j < n; j++) {
                // 0. 교환한 적이 있는 학생인가?
                if(ch[j] == 1) continue;
                // 1. 최솟값이 유니크한가?
                if(!isMinUnique(fruit[i])) continue;

                // 2. 최솟값인 과일이 서로 달라야 한다
                int innerMinIdx = minIndex(fruit[j]);
                if(outerMinIdx == innerMinIdx) continue;

                // 3. 최솟값인 과일이 그대로 최솟값이어야 한다.
                if(fruit[i][outerMinIdx] + 1 < fruit[i][innerMinIdx] &&
                        fruit[j][innerMinIdx] + 1 < fruit[j][outerMinIdx]) {
                    ch[i] = 1;
                    ch[j] = 1;
                    fruit[i][outerMinIdx]++;
                    fruit[i][innerMinIdx]--;
                    fruit[j][innerMinIdx]++;
                    fruit[j][outerMinIdx]--;
                }

            }
        }
        for(int i = 0; i < n; i++) {
            answer += Arrays.stream(fruit[i]).min().getAsInt();
        }
        return answer;
    }
    /**
     * 정답
     * */
    public int solByTeacher(int[][] fruit) {
        int answer = 0;
        int n = fruit.length;
        int[] ch = new int[n];
        for (int i = 0; i < n; i++) {
            if(ch[i] == 1) continue;
            if(isMinUnique2(fruit[i]) == false) continue;
            for (int j = i + 1; j < n; j++) {
                if(ch[j] == 1) continue;
                if(isMinUnique2(fruit[j]) == false) continue;
                int a = getMinIndex2(fruit[i]);
                int b = getMinIndex2(fruit[j]);
                if (a != b && fruit[i][b] > 0 && fruit[j][a] > 0) {
                    if (fruit[i][a] + 1 <= fruit[i][b] - 1 && fruit[j][b] + 1 <= fruit[j][a] - 1) {
                        fruit[i][a]++;
                        fruit[i][b]--;
                        fruit[j][b]++;
                        fruit[j][a]--;
                        ch[i] = 1;
                        ch[j] = 1;
                        break;
                    }
                }
            }
        }
        for(int[] x : fruit){
            answer += getMin2(x);
        }
        return answer;
    }

    public boolean isMinUnique2(int[] arr) {
        int cnt = 0;
        int min = getMin2(arr);
        for (int x : arr) {
            if(x == min) cnt++;
        }
        return cnt == 1;
    }

    public int getMin2(int[] arr) {
        int min = 100;
        for (int x : arr) {
            min = Math.min(min, x);
        }
        return min;
    }

    public int getMinIndex2(int[] arr) {
        int min = getMin2(arr);
        for (int i = 0; i < 3; i++) {
            if(arr[i] == min) return i;
        }
        return 0;
    }

    public static void main(String[] args){
        과일가져가기_6 T = new 과일가져가기_6();
        System.out.println(T.solByTeacher(new int[][]{{10, 20, 30}, {12, 15, 20},
                {20, 12, 15}, {15, 20, 10}, {10, 15, 10}}));
        System.out.println(T.solByTeacher(new int[][]{{10, 9, 11}, {15, 20, 25}}));
        System.out.println(T.solByTeacher(new int[][]{{0, 3, 27}, {20, 5, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}}));
        System.out.println(T.solByTeacher(new int[][]{{3, 7, 20}, {10, 15, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}, {12, 12, 6}, {10, 20, 0}, {5, 10, 15}}));
    }
}
