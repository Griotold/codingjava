package kim.array;

public class 피보나치수열_4 {
    /**
     * 배열을 쓰지 않는 방식
     * */
    public void solution(int n) {
        int a = 1, b = 1, c;
        System.out.print(a + " " + b + " ");
        for(int i = 2; i < n; i++) {
            c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
    }

    /**
     * 배열을 쓰는 방식
     * */
    public int[] solution2(int N) {
        int[] answer = new int[N];
        answer[0] = 1;
        answer[1] = 1;
        for(int i = 2; i < N; i++) {
            answer[i] = answer[i - 2] + answer[i - 1];
        }
        return answer;
    }
}
