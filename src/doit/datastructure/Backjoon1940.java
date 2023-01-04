package doit.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Backjoon1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int inputAmount = Integer.parseInt(br.readLine());
        int[] valueArr = new int[inputAmount];
        int targetValue = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<inputAmount; i++) {
            valueArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(valueArr);

        int count = 0;
        int forward = 0;
        int backward = inputAmount-1;

        while(forward != backward) {
            int temp = valueArr[forward] + valueArr[backward];
            if (temp > targetValue) {
                backward--;
            } else if (temp == targetValue) {
                count++;
                forward++;
                backward--;
            } else {
                forward++;
            }
            if (backward<forward) break;
        }
        System.out.println(count);
    }
}
