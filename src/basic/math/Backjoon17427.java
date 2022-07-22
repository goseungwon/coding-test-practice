package basic.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backjoon17427 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int output =0;
        int n= Integer.parseInt(br.readLine());
        for (int i=1; i<=n; i++){
            output+=yaksu(i,1);
        }


        System.out.println(output);

    }

    private static int yaksu(int n, int k){
        int output=1;
        output+=n;
        if (n<k) return output;
        if (n==1) return 1;
        for (int i=2; i<=Math.sqrt(n); i++){
            if (n%i==0){
                if (i!=n/i) {
                    output += i*k;
                    output += yaksu(n/i,k*i);
                    break;
                }else {
                    output += i*k;
                    output +=i*yaksu(i,k*i);
                    break;
                }
            }
        }
        return output;
    }
}