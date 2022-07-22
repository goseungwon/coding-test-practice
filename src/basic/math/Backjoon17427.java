package basic.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backjoon17427 {
    static int output =0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n= Integer.parseInt(br.readLine());
        yaksu(n);

        System.out.println(output);



    }

    private static int yaksu(int n){
        if (n==1) return output+=1;
        for (int i=1; i<=Math.sqrt(n); i++){
            if (n%i==0){
                if (i!=n/i) {
                    output += i;
                    output += n / i;
                }else output+=i;
            }
        }
        return yaksu(n-1);
    }
}