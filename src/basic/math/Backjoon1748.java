package basic.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backjoon1748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n= Integer.parseInt(br.readLine());
        int count=0;

        for (int i=8; i>0; i--){
            if (n >= Math.pow(10, i)) {
                count += (i+1) * ((n - Math.pow(10, i)+1));
                n = (int) Math.pow(10, i)-1;
            }
        }count+=n;

        System.out.println(count);
    }
}
