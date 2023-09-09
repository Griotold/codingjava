package programmers;

public class 체육복_배열 {

    public int solution(int n, int[] lost, int[] reserve) {
        // 1. students 배열 선언
        int[] students = new int[n + 2];

        // 2. reserve 정보 반영
        for (int i = 0 ; i < reserve.length; i++) {
            students[reserve[i]]++;
        }

        // 3. lost 정보 반영
        for (int i = 0; i < lost.length; i++) {
            students[lost[i]]--;
        }

        // 4. 체육복 빌려주기
        for (int i = 1; i <= n; i++) {
            if (students[i] == 1) {
                if (students[i-1] == -1) {
                    students[i-1]++;
                    students[i]--;
                } else if (students[i+1] == -1) {
                    students[i+1]++;
                    students[i]--;
                }
            }
        }

        // 5. students 배열을 가지고 count
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (students[i] >= 0) count++;
        }
        return count;
    }
}
