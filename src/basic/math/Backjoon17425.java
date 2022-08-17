package basic.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Backjoon17425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long arrfx[] = new long[1000001];
        long arrgx[] = new long[1000001];
        Arrays.fill(arrfx,1);
        arrgx[1]=1;

        for (int i=2; i<arrfx.length; i++){
            for (int j = 1; j*i <arrfx.length; j++) {
                arrfx[i*j]+=i;
            }
            arrgx[i] = arrgx[i-1] + arrfx[i];
        }

        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            int input = Integer.parseInt(br.readLine());
            sb.append(arrgx[input] +"\n");
        }
        System.out.println(sb);
    }



}