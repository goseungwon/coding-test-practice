package bj.No8;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Math.sqrt;

public class Backjoon1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        if (s<=2) {
            bw.write(("2") + "\n");
            s = 3;
        }

        Loop:
        for (int i=s; i<=e; i++){
            if (i%2==0) {
                continue;
            }
            for (int j=3; j<=sqrt(i); j+=2) {
                if (i % j == 0)
                    if (j!=i)
                    continue Loop;
            }
            bw.write(String.valueOf(i)+"\n");
            i++;
        }
        bw.flush();
        bw.close();
    }
}
