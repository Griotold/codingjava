import java.io.*;
import java.util.*;
public class Main {
    /**
     * 4. 단어 뒤집기
     * 단어가 들어오면 단어를 뒤집어서 출력
     * good -> doog
     * 근데 단어가 여러 개 들어온다.
     * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            list.add(br.readLine()); // good Time Big
        }

        ArrayList<String> answerList = new ArrayList<>();
        int size = list.size(); // 3
        while(size != 0) {
            // 뒤집어 보자
            String answer = "";
            String temp = list.remove(0);
            for(int i = temp.length() - 1; i >= 0; i--) {
                answer += temp.charAt(i);
            }
            answerList.add(answer);
            size--;
        }
        for (String reversed : answerList) {
            bw.write(reversed);
            bw.newLine();
        }
        br.close();
        bw.close();
    }
}