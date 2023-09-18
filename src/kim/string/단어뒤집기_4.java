package kim.string;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * StringBuilder 사용
 * */
public class 단어뒤집기_4 {
    public ArrayList<String> solution(int n, String[] strings) {
        ArrayList<String> answer = new ArrayList<>();
        for (String x : strings) {
            String temp = new StringBuilder(x).reverse().toString();
            answer.add(temp);
        }
        return answer;
    }
    public static void main(String[] args) {
        단어뒤집기_4 T = new 단어뒤집기_4();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String[] str = new String[n];
        for(int i = 0; i < n; i++) {
            str[i] = kb.next();
        }
        for(String x : T.solution(n, str)){
            System.out.println(x);
        }
    }
}
