package basic.BF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Backjoon3085 {
    static char[][] arr;
    static int max=0;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n= Integer.parseInt(br.readLine());
        arr = new char[n][n];

        for (int i=0; i<n; i++){
            String input=br.readLine();
            for (int j=0; j<input.length(); j++){
                arr[i][j]=input.charAt(j);
            }
        }
        //배열에 입력
        for (int i=0; i<n; i++){
            for (int j=0; j<n-1;j++) {
                swap(i,j);
                getMax();
                getMax2();
                swap(i,j);

                swap2(i,j);
                getMax();
                getMax2();
                swap2(i,j);
            }
        }
        System.out.println(max);
    }


    private static void swap(int i, int j){
        char swap = arr[i][j];
        arr[i][j] = arr[i][j + 1];
        arr[i][j + 1] = swap;
    }
    private static void swap2(int i, int j){
        char swap = arr[j][i];
        arr[j][i] = arr[j+1][i];
        arr[j+1][i] = swap;
    }

    private static void getMax() {
        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j = 0; j < n - 1; j++) {
                if (arr[j][i] == arr[j + 1][i]) count++;
                else count = 1;
                max = Math.max(count, max);
            }

        }
    }

    private static void getMax2(){
        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j = 0; j < n - 1; j++) {
                if (arr[i][j] == arr[i][j + 1]) count++;
                else count = 1;
                max = Math.max(max, count);
            }
        }
    }
}