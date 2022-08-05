package sequence;

import java.io.*;
import java.util.StringTokenizer;

public class Backjoon1085 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int output=x;
        if (output>y) output=y;
        if (output>w-x) output=w-x;
        if (output>h-y) output=h-y;

        bw.write(String.valueOf(output));
        bw.flush();
        bw.close();
    }
}
