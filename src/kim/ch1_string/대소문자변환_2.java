package kim.ch1_string;

public class 대소문자변환_2 {

    public String solution(String str) {
        String answer = "";
        for(char c : str.toCharArray()) {
            if(Character.isLowerCase(c)) {
                answer += Character.toUpperCase(c);
            } else {
                answer += Character.toLowerCase(c);
            }
        }
        return answer;
    }
}
