package kim.ch6_sort_binary_search_decision;

public class 좌표정렬_7 {
    /**
     * Comparable의 comparTo를 오버라이딩 한 후
     * Collections.sort(list) 호출
     * */
}

class Point implements Comparable<Point> {
    public int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    /**
     * 오름차순
     * */
    @Override
    public int compareTo(Point o) {
        if(this.x == o.x) return this.y - o.y;
        return this.x - o.x;
    }
}
