package summer_winter_coding;
import java.util.*;
/**
 * int[]는 Collections.reverseOrder()나 람다표현식이 안먹힌다.
 * Integer[]로 만들어줘야 한다
 * */
public class 숫자게임 {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int n = A.length;
        // Arrays.sort(arr, Collections.reverseOrder());
        // Arrays.sort(arr, (i1, i2) -> i2 - i1);
        Integer[] boxedA = Arrays.stream(A)
                .boxed()
                .toArray(Integer[]::new);
        Integer[] boxedB = Arrays.stream(B)
                .boxed()
                .toArray(Integer[]::new);
        Arrays.sort(boxedA, (i1, i2) -> i2 - i1);
        Arrays.sort(boxedB, (i1, i2) -> i2 - i1);
        int j = 0; // B를 가리키는 인덱스
        int ans = 0; // 점수

        for (int i = 0; i < n; i++) { // i는 A를 가리키는 인덱스
            if (boxedA[i] < boxedB[j]) { // B가 더 클 때 
                answer++; // 점수 증가
                j++; // B를 가리키는 인덱스 증가
            }
        }
        return answer;
    }
}
