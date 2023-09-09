package programmers;

public class 겹치는선분의길이 {
    public int solution(int[][] lines) {
        // 1. arr 배열 및 변수 초기화
        int answer = 0;
        int[] arr = new int[201];

        // 2. lines 정보를 arr 배열에 적용 // [[0, 1], [2, 5], [3, 9]]
        for(int i = 0; i < lines.length; i++) {
            int start = lines[i][0] + 100;
            int end = lines[i][1] + 100;
            for(int j = start; j < end; j++) {
                arr[j]++;
            }
        }

        // 3. arr 배열에서 겹친 부분 세기
        for (int ele : arr) {
            if (ele > 1) {
                answer++;
            }
        }
        return answer;
    }
}
