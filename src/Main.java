import java.io.*;
import java.util.*;

class Point implements Comparable<Point> {
    public int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if(this.x == o.x) return this.y - o.y;
        return this.x - o.x;
    }
}
public class Main {
    // 5
    //2 7
    //1 3
    //1 2
    //2 5
    //3 6
//    public int[][] sol(int N, int[][] arr) {
//        return arr;
//    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Point> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Point(x, y));
        }
        Collections.sort(list);
        for (Point p : list) System.out.println(p.x + " " +p.y);
        br.close();
    }
}