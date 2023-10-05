import java.io.*;
import java.util.*;
public class Main {
    // 5
    //0 0 0 0 0
    //0 0 1 0 3
    //0 2 5 0 1
    //4 2 4 4 2
    //3 5 1 3 1
    //8
    //1 5 3 5 1 2 1 4             --->  4
    public int solution(int N, int[][] board, int M, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < M; i++) {
            int column = moves[i] - 1;
            for(int j = 0; j < N; j++) {
                int top = board[j][column];
                if(top != 0) {
                    if(!stack.isEmpty() && stack.peek() == top){
                        stack.pop();
                        answer += 2;
                    }
                    else {
                        stack.push(top);
                    }
                    board[j][column] = 0;
                    break;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int M = Integer.parseInt(br.readLine());
        int[] moves = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            moves[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(T.solution(N, board, M, moves));
        br.close();
    }
}