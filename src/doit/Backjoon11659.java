package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int arrLen = Integer.parseInt(st.nextToken());
        int tc = Integer.parseInt(st.nextToken());

        int[] input = new int[arrLen+1];
        long[] total = new long[arrLen+1];
        input[0]=0;
        total[0]=0;

        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=arrLen; i++){
            input[i] = Integer.parseInt(st.nextToken());
            total[i] = total[i-1] + input[i];
        }

        for (int i=0; i<tc; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken());

            sb.append(total[end] - total[start] + "\n");
        }

        System.out.println(sb);
    }
}
