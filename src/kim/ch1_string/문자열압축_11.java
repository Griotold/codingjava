package kim.ch1_string;

public class 문자열압축_11 {
    public String solution(String str) {
        String answer = "";
//        str = str + " ";
        answer += str.charAt(0);
        int count = 1;
        for(int i = 1; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == str.charAt(i - 1)){
                count++;
            } else {
                if(count != 1) {
                    answer += count;
                }
                answer += ch;
                count = 1;
            }
        }
        return answer;
    }
}
