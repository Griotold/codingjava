package kim.array;

public class 임시반장구하기_11 {
    public int solution(int N, int[][] arr) {
        int answer = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= N; i++) {
            int count = 0;
            for(int j = 1; j <= N; j++) {
                if(i == j )continue;
                for(int k = 1; k <= 5; k++) {
                    if(arr[i][k] == arr[j][k]) {
                        count++;
                        break;
                    }
                }
            }
            if(count > max) {
                max = count;
                answer = i;
            }
        }
        return answer;
    }
}
