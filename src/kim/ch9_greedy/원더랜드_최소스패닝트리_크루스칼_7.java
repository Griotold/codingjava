package kim.ch9_greedy;

import kim.ch9_greedy.data.City;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 원더랜드_최소스패닝트리_크루스칼_7 {
    static int[] unf;

    public static int find(int v) {
        if(v == unf[v]) return v;
        else return unf[v] = find(unf[v]);
    }
    public static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if(fa != fb) unf[fa] = fb;
    }
    public static void main(String[] args) throws IOException {
        원더랜드_최소스패닝트리_크루스칼_7 T = new 원더랜드_최소스패닝트리_크루스칼_7();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        unf = new int[N + 1];
        ArrayList<City> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) unf[i] = i;
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.add(new City(a, b, c));
        }
        // 크루스칼 알고리즘!
        int answer = 0;
        Collections.sort(list);
        for (City city : list) {
            int fv1 = find(city.v1);
            int fv2 = find(city.v2);
            if (fv1 != fv2) {
                answer += city.cost;
                union(city.v1, city.v2);
            }
        }

        System.out.println(answer);
        br.close();
    }
}
