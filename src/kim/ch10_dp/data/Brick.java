package kim.ch10_dp.data;

public class Brick implements Comparable<Brick>{
    public int area; // 넓이
    public int height; // 높이
    public int weight; // 무게

    public Brick(int a, int h, int w) {
        area = a;
        height = h;
        weight = w;
    }
    // 넓이를 기준으로 내림차순
    @Override
    public int compareTo(Brick o) {
        return o.area - this.area;
    }
}
