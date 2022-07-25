package basic.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backjoon17425 {

    /*
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num= Integer.parseInt(br.readLine());

        for (int j=0; j<num; j++){
            int input=Integer.parseInt(br.readLine());
            sb.append(getOutput(input)+"\n");
        }

        System.out.println(sb);
    }

    private static long getOutput(int input) {
        long output=input*(input+1)/2;
        for (int i = 1; i<=input/2; i++){
            output +=i*(input /i);
        }
        return output;
    }
     */

    public static void main(String[] args) {
        int arr[] = new int[1000001];
        arr[1]=1;
        for (int i=2; i<arr.length; i++){
            arr[i]+=arr[i-1]+getOutput(i);
        }
    }

    private static long getOutput(int i) {
        long output=0;
        for (int j=0; j<Math.sqrt(i); j++){

        }
        return 0;

    }


}