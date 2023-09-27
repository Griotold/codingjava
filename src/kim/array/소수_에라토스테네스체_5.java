package kim.array;

public class 소수_에라토스테네스체_5 {
    /**
     * 에라토스테네스체 구현
     * */
    public int solution(int n) {
        int answer = 0;
        int[] ch = new int[n + 1];
        for(int i = 2; i <= n; i++) {
            if(ch[i] == 0) {
                answer++;
                for(int j = i; j <= n; j = j + i)
                    ch[j] = 1;
            }
        }
        return answer;
    }

    /**
     * 내 풀이
     * */
    public int solution2(int N) {
        int answer = 0;
        for(int i = 2; i <= N; i++){
            for(int j = 2; j * j <= i; j++) {
                if(i % j == 0) {
                    answer++;
                    break;
                }
            }
        }
        answer++;
        return N - answer;
    }
}
