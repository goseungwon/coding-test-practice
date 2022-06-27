import java.io.*;
import java.util.Scanner;

public class Backjoon2447 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
     static char[][] arr;


    public static void main(String[] args) throws IOException {

        int n=Integer.parseInt(br.readLine());

        arr = new char[n][n];

        for (int i=0; i<n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = '*';
            }
        }

        star(3*n, 0, 0);

        for (int i=0; i<n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

    }

    public static void star(int n, int x, int y){

        if (n==1)
            return;


            if (x%3==1 && y%3==1)
                arr[x][y]=' ';
            star(n / 3, (n / 3) + 3, (n / 3) + 3);


        }
    }

