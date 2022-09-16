package doit;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Backjoon11657 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int city, degree;
    static long distance[];
    static Edge edges[];

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        city = Integer.parseInt(st.nextToken());
        degree = Integer.parseInt(st.nextToken());

        edges = new Edge[degree + 1];
        distance = new long[city + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        for (int i = 0; i < degree; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(start, end, time);
        }

        //벨만 포드 수행
        distance[1] = 0;
        for (int i = 1; i < city; i++) {
            for (int j = 0; j < degree; j++) {
                Edge edge = edges[j];

                if (distance[edge.start] != Integer.MAX_VALUE
                        && distance[edge.end] > distance[edge.start] + edge.time) {
                    distance[edge.end] = distance[edge.start] + edge.time;
                }
            }
        }
        boolean mCycle = false;
        for (int i = 0; i < degree; i++) {
            Edge edge = edges[i];
            if (distance[edge.start] != Integer.MAX_VALUE
                    && distance[edge.end] > distance[edge.start] + edge.time) {
                mCycle = true;
            }
        }
        if (!mCycle) {
            for (int i = 2; i <= city; i++) {
                if (distance[i] == Integer.MAX_VALUE)
                    System.out.println("-1");
                else
                    System.out.println(distance[i]);
            }
        } else {
            System.out.println("-1");
        }
    }
}
class Edge {
    int start, end, time;

    public Edge(int start, int end, int time) {
        this.start = start;
        this.end = end;
        this.time = time;
    }
}
