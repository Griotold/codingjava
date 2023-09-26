package kim.string;

public class 숫자만추출_9 {
    public int solution(String str) {
        int answer = 0;
        String temp = "";
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(Character.isDigit(ch)){
                temp += ch;
            }
        }
        answer = Integer.parseInt(temp);
        return answer;
    }

    /**
     * 아스키 코드
     * */
    public int solution2(String str) {
        int answer = 0;
        for(char x : str.toCharArray()){
            if(x >= 48 && x <= 57) {
                answer = answer * 10 +(x - 48);
            }
        }
        return answer;
    }
}
