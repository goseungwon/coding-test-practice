package sequence.No16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon9184 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][][] arr = new int[21][21][21];

        for (int i=0; i<21; i++){
            for (int j=0; j<21; j++){
                for (int k=0; k<21; k++){
                    if (i==0 || j==0 || k==0) arr[i][j][k] = 1;
                    else if (i<j && j<k){
                        arr[i][j][k] = arr[i][j][k-1] + arr[i][j-1][k-1] - arr[i][j-1][k];
                    } else {
                        arr[i][j][k] = arr[i-1][j][k] + arr[i-1][j-1][k] + arr[i-1][j][k-1] - arr[i-1][j-1][k-1];
                    }
                }
            }
        }

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int A = a;
            int B = b;
            int C = c;

            if (a==-1 && b==-1 && c==-1){
                break;
            }
            if (a<=0 || b<=0 || c<=0){
                A=0;
                B=0;
                C=0;
            }else {
                if (a > 20 || b > 20 || c > 20) {
                    A = 20;
                    B = 20;
                    C = 20;
                }
            }
                System.out.printf("w(%d, %d, %d) = %d\n", a, b, c, arr[A][B][C]);
        }
    }
}
