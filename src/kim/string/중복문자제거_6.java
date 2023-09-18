package kim.string;
/**
 * 중복문자제거
 * */
public class 중복문자제거_6 {
    public String solution(String str) {
        String answer = "";
        for(int i = 0; i < str.length(); i++) {
            // System.out.println(str.charAt(i) + " " + i + " " + str.indexOf(str.charAt(i)));
            if(str.indexOf(str.charAt(i)) == i) {
                answer += str.charAt(i);
            }
        }
        return answer;
    }
}
