import java.io.*;
import java.util.*;
public class Main {
    public ArrayList<String> solution(int t, String[] str) {
        ArrayList<String> answer = new ArrayList<>();
        for (String x : str) {
            char[] s = x.toCharArray();
            int lt = 0, rt = x.length() - 1;
            while(lt < rt) {
                char temp = s[lt];
                s[lt] = s[rt];
                s[rt] = temp;
                lt++;
                rt--;
            }
            String reversed = String.valueOf(s);
            answer.add(reversed);
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        String[] str = new String[t];
        for (int i = 0; i < t; i++) {
            str[i] = br.readLine();
        }
        for (String x : T.solution(t, str)) {
            System.out.println(x);
        }


        br.close();
    }
}