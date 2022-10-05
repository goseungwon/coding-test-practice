package basic.BF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Backjoon15651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int top = Integer.parseInt(st.nextToken());
        int digit = Integer.parseInt(st.nextToken());

        int[] arr = new int[digit+1];
        Arrays.fill(arr, 1);


        while(arr[0]==1){
            for (int i=1; i<=digit; i++){
                sb.append(arr[i]+" ");
            }
            sb.append("\n");

            arr[digit]++;

            for (int i=digit; i>=1; i--){
                if (arr[i]>top){
                    arr[i]=1;
                    arr[i-1]++;
                }else{
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}
