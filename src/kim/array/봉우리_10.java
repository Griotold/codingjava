package kim.array;

public class 봉우리_10 {
    public int solution(int N, int[][] arr) {
        int answer = 0;
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                int now = arr[i][j];
                if(now > arr[i][j+1] && now > arr[i+1][j] && now > arr[i-1][j] && now > arr[i][j-1])
                    answer++;
            }
        }
        return answer;
    }
}
