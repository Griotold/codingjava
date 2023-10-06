import java.io.*;
import java.util.*;
public class Main {
    // CBA
    // CBDAGE
    // C, G, E, A, D, B
    public String sol(String str1, String str2) {
        String answer = "NO";
        List<Character> queue = new ArrayList<>();
        for(char ch : str1.toCharArray()) queue.add(ch);
        for(char ch : str2.toCharArray()) {
            if (!queue.isEmpty()) {
                char first = queue.get(0);
                if(ch == first) queue.remove(0);
            }
        }
        if(queue.isEmpty()) answer = "YES";
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        System.out.println(T.sol(str1, str2));
        br.close();
    }
}