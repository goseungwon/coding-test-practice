package basic.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Backjoon2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int hight=0;
        int a=0,b=0;
        int[] arr = new int[9];
        for (int i=0; i<arr.length; i++){
            arr[i]= Integer.parseInt(br.readLine());
            hight+=arr[i];
        }
        Arrays.sort(arr);

        for (int i=0; i< arr.length; i++){
            for (int j=i+1; j<arr.length; j++){
                if (hight-arr[i]-arr[j]==100){
                    a=i;
                    b=j;
                }
            }
        }
        for (int i=0; i<arr.length; i++){
            if (i == a || i==b){
                continue;
            }
            System.out.println(arr[i]);
        }
    }
}
