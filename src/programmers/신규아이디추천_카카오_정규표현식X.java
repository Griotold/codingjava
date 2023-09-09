package programmers;

public class 신규아이디추천_카카오_정규표현식X {
    public String solution(String new_id) {
        // 1. 소문자로 치환
        String answer = "";
        new_id = new_id.toLowerCase();

        // 2. 소문자, 숫자, 빼기, 밑줄, 마침표
        for (int i = 0; i < new_id.length(); i++) {
            char ch = new_id.charAt(i);
            if (Character.isAlphabetic(ch) ||
                    Character.isDigit(ch) || ch == '-'
                    || ch == '_' || ch == '.')
                answer += ch;
        }

        // 3. 마침표가 2개 이상이면
        while(answer.indexOf("..") != -1) {
            answer = answer.replace("..", ".");
        }

        // 4. 마침표(.) 가 처음이나 끝에 있다면 제거
        if(!answer.isEmpty() && answer.charAt(0) == '.')
            answer = answer.substring(1);
        if(!answer.isEmpty() && answer.charAt(answer.length() - 1) == '.')
            answer = answer.substring(0, answer.length() - 1);

        // 5. 빈 문자열이라면
        if (answer.isEmpty())
            answer = "a";

        // 6. 길이가 16이상이라면
        if (answer.length() > 15) {
            answer = answer.substring(0, 15);
            if (answer.charAt(answer.length() - 1) == '.')
                answer = answer.substring(0, answer.length() - 1);
        }

        // 7. 길이가 2자 이하라면
        while(answer.length() < 3)
            answer += answer.charAt(answer.length() - 1);

        return answer;
    }
}
