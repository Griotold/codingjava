package ch1;

import java.util.Scanner;

public class SumOfNum_11720 {

    public void logic() {
        //5
        //54321
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String inputNumbers = sc.next();
        char[] charArray = inputNumbers.toCharArray();
        int sum = 0;
//        for (char c : charArray) {
//            System.out.println("c = " + c);
//            int num = c - '0';
//            sum += c;
//        }
        for (int i = 0; i < charArray.length; i++) {
            sum += charArray[i] - '0';
        }
        System.out.println("sum = " + sum);
    }
}
