import java.io.*;
import java.util.*;
public class Main {
    /**
     * 다이얼 5622
     * 할머니가 외운 단어 -> 전화를 걸기 위한 최소 시간
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // WA
        String str = br.readLine();
        int count = 0;
        for(int i = 0; i < str.length(); i++) {
            char value = str.charAt(i);
            if(value < 68) count += 3;
            else if(value < 71) count += 4;
            else if(value < 74) count += 5;
            else if(value < 77) count += 6;
            else if(value < 80) count += 7;
            else if(value < 84) count += 8;
            else if(value < 87) count += 9;
            else count += 10;
        }
        bw.write(String.valueOf(count));

        br.close();
        bw.close();
    }
}