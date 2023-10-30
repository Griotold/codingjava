package it_big_company_problem.ch6_DFS;
/**
 * 내 풀이 - 마지막 예제 틀렸음
 *        - 조합 뽑는 경우의 수 구현이 틀림
 * */
public class 바둑대회_3 {
    static int N, answer = Integer.MAX_VALUE;
    static int[] ch, A, B;

    public void DFS(int L, int s, int[][] cans) {
        if(L == N / 2) {
            int idxA = 0;
            int idxB = 0;
            int sumA = 0;
            int sumB = 0;
            for (int i = 0; i < N; i++) {
                if(ch[i] == 1) A[idxA++] = i;
                else B[idxB++] = i;
            }
            for(int i = 0; i < N / 2; i++) {
                sumA += cans[A[i]][0];
                sumB += cans[B[i]][1];
            }
            answer = Math.min(answer, Math.abs(sumA-sumB));
        } else {
            for(int i = s; i < N; i++) {
                if(ch[i] == 0) {
                    ch[i] = 1;
                    DFS(L + 1, s + 1, cans); // 여기가 잘못됨 DFS(L+1, i+1, cans); 가 맞다.
                    ch[i] = 0;
                }
            }
        }
    }
    public int solution(int[][] cans){
        N = cans.length;
        ch = new int[N];
        A = new int[N / 2];
        B = new int[N / 2];
        DFS(0, 0, cans);
        return answer;
    }

    public static void main(String[] args){
        바둑대회_3 T = new 바둑대회_3();
        System.out.println(T.solution(new int[][]{{87, 84}, {66, 78},
                {94, 94}, {93, 87}, {72, 92}, {78, 63}}));
        System.out.println(T.solution(new int[][]{{10, 20}, {15, 25},
                {35, 23}, {55, 20}}));
        System.out.println(T.solution(new int[][]{{11, 27}, {16, 21},
                {35, 21}, {52, 21}, {25, 33},{25, 32}, {37, 59}, {33, 47}}));
    }
}
