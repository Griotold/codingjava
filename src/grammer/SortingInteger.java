package grammer;

import java.util.Arrays;
import java.util.Comparator;
/**
 * 오른쪽이 크면 음수, 왼쪽이 크면 양수
 * */
public class SortingInteger {
    public static void main(String[] args) {
        Object[] arr = {30, 50, 10, 40, 20, "str"};

//        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));

        Arrays.sort(arr, new DescComp());
        System.out.println(Arrays.toString(arr));
    }
}

class DescComp implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        // Integer가 아니면 맨 앞으로 이동
        if (!(o1 instanceof Integer && o2 instanceof Integer)) {
            return -1;
        }

        Integer i1 = (Integer)o1;
        Integer i2 = (Integer)o2;
        return i1.compareTo(i2) * -1;
        // return i2 - i1;
        // return i2.compareTo(i1);
    }
}
