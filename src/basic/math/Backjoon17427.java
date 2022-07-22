package basic.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backjoon17427 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long output =0;
        int n= Integer.parseInt(br.readLine());
        for (int i=1; i<=n; i++){
            output+=i*(n/i);
        }

        System.out.println(output);

    }
}