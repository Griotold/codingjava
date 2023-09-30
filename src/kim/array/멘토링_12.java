package kim.array;

public class 멘토링_12 {
    public int solution(int N, int M, int[][] arr) {
        int answer = 0;
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++) {
                int cnt = 0;
                for(int k = 0; k < M; k++) {
                    int pi = 0, pj = 0;
                    for(int s = 0; s < N; s++) {
                        if(arr[k][s] == i) pi = s;
                        if(arr[k][s] == j) pj = s;
                    }
                    if(pi < pj) cnt++;
                }
                if (cnt == M) answer++;
            }
        }
        return answer;
    }
}
