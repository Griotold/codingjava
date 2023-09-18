package kim.cproblem;

public class 배수합_1 {

    /**
     * 자연수 N이 입력되면 1부터 N까지 수 중
     * M의 배수들의 합을 출력하는 프로그램
     * 입력 : 15 3
     * 출력 : 45
     * */
    public int solution(int N, int M) {
        int answer = 0;
        // 1. N까지 반복문을 돌다가 배수라면 answer에 더한다
        for(int i = 1; i <= N; i++){
            if (i % M == 0) answer += i;
        }

        // 2. answer 출력

        return answer;
    }
}
