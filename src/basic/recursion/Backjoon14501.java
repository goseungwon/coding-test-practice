package basic.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int day = Integer.parseInt(br.readLine());
        int[] time = new int[day];
        int[] pay = new int[day];
        int[] total = new int[day + 1];


        for (int i = 0; i < day; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            pay[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = day - 1; i >= 0; i--) {
            if (i + time[i] > day) {
                total[i] = total[i + 1];
                continue;
            }
            if (i + time[i] <= day) {
                total[i] = Math.max(total[i + 1], pay[i] + total[i + time[i]]);
            }
        }
        System.out.println(total[0]);
    }
}
