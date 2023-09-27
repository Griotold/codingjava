package kim.array;

public class 가위바위보_3 {
    /**
     * 강사님 풀이
     * */
    public String solution(int n, int[] a, int[] b) {
        String answer = "";
        for(int i = 0; i < n; i++) {
            if(a[i] == b[i]) answer += "D";
            else if (a[i] == 1 && b[i] == 3) answer += "A";
            else if (a[i] == 2 && b[i] == 1) answer += "A";
            else if (a[i] == 3 && b[i] == 2) answer += "A";
            else answer += "B";
        }
        return answer;
    }

    /**
     * 내 풀이
     * */
    public char[] solution2(int N, int[] aArr, int[] bArr) {
        char[] answer = new char[N];
        for(int i = 0; i < N; i++) {
            int a = aArr[i];
            int b = bArr[i];
            if (a == b) {
                answer[i] = 'D';
            } else {
                if(a == 1) {
                    if(b == 2) answer[i] = 'B';
                    else answer[i] = 'A';
                } else if(a == 2) {
                    if(b == 1) answer[i] = 'A';
                    else answer[i] = 'B';
                } else {
                    if (b == 1) answer[i] = 'B';
                    else answer[i] = 'A';
                }
            }
        }
        return answer;
    }
}
