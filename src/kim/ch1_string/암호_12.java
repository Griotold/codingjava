package kim.ch1_string;

public class 암호_12 {
    public String solution(String str, int N) {
        String answer = "";
        for(int i = 0; i < N; i++) {
            String tmp = str.substring(0, 7)
                    .replace("#", "1")
                    .replace("*", "0");
            int num = Integer.parseInt(tmp, 2);
            answer += (char)num;
            str = str.substring(7);
        }
        return answer;
    }
}
