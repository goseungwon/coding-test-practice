package basic.BF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backjoon9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        int[] arr = new int[12];
        arr[1]=1;
        arr[2]=2;
        arr[3]=4;

        for (int j=4; j<=11; j++){
            arr[j] = arr[j-1] + arr[j-2] + arr[j-3];
        }

        for (int i=0; i<tc; i++){
            System.out.println(arr[Integer.parseInt(br.readLine())]);

        }
    }
}
