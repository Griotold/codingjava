package grammer;

import java.util.Arrays;
import java.util.Comparator;
/**
 * Comparator 와 Comparable 예제 - String
 * 오른쪽이 크면 음수, 왼쪽이 크면 양수
 * */
public class SortingString {
    public static void main(String[] args) {
        String[] strArr = {"cat", "Dog", "lion", "tiger"};

        Arrays.sort(strArr);
        System.out.println("strArr = " + Arrays.toString(strArr));

        Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER);
        System.out.println("strArr = " + Arrays.toString(strArr));

        Arrays.sort(strArr, new Descending());
        System.out.println("strArr = " + Arrays.toString(strArr));
    }
}
class Descending implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        if (o1 instanceof Comparable && o2 instanceof Comparable) {
            Comparable c1 = (Comparable) o1;
            Comparable c2 = (Comparable) o2;
            return c1.compareTo(c2) * -1; // 기본 정렬 방식의 역으로 변경한다.
            // return c2.compareTo(c1);
        }
        return -1;
    }
}
