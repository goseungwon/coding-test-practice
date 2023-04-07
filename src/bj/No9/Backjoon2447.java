package bj.No9;

import java.io.*;

public class Backjoon2447 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
     static char[][] arr;


    public static void main(String[] args) throws IOException {

        int n=Integer.parseInt(br.readLine());

        arr = new char[n][n];

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                arr[i][j] = ' ';
            }
        }

        star(n, 0, 0);

        for (int i=0; i<n; i++) {
            for (int j = 0; j < n; j++) {
                bw.write(arr[i][j]);
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    public static void star(int n, int x, int y){

        if (n==1) {
            arr[x][y]='*';
            return;
        }

        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                if (!(i==1 && j==1)){
                    star(n/3, x+i*(n/3), y+j*(n/3));
                }

            }
        }
    }
}

