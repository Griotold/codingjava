import java.io.*;
import java.util.*;
public class Main {
    public String solution(String str) {
        String answer = "NO";
        str = str.toLowerCase()
                .replaceAll("[^a-z]", "");
        String reversed = new StringBuilder(str).reverse().toString();
        if (str.equals(reversed)) answer = "YES";

        return answer;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(T.solution(str));

        br.close();
    }
}