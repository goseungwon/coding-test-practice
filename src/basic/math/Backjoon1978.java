package basic.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputNum= Integer.parseInt(br.readLine());
        int count=0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<inputNum; i++){
            int input= Integer.parseInt(st.nextToken());

            boolean sosu = sosu(input);
            if (sosu) count++;

        }
        System.out.println(count);

    }

    private static boolean sosu(int input){
        if (input==1) return false;
        for (int i=2; i<=Math.sqrt(input); i++){
            if (input%i==0)
                return false;
        }
        return true;
    }
}
