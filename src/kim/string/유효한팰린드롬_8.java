package kim.string;

public class 유효한팰린드롬_8 {
    public String solution(String str) {
        String answer = "NO";
        str = str.toLowerCase()
                .replaceAll("[^a-z]", "");
        String reversed = new StringBuilder(str).reverse().toString();
        if (str.equals(reversed)) answer = "YES";

        return answer;
    }
}
