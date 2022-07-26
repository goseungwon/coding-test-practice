package basic.BF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backjoon3085 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n= Integer.parseInt(br.readLine());
        char [][] arr = new char[n][n];
        int max=0, maxLine;
        boolean maxHang;
        boolean hang=false;
        int y=0, c=0, p=0,z=0;

        for (int i=0; i<arr.length; i++){
            String input=br.readLine();
            for (int j=0; j<arr.length; j++){
                arr[i][j]=input.charAt(j);
            }
        }

        for (int i=0; i<arr.length; i++){
            y=0; c=0; p=0; z=0;
            for (int j=0; j<arr.length; j++){
                    switch (arr[i][j]){
                        case 'Y' : y++; break;
                        case 'C' : c++; break;
                        case 'P' : p++; break;
                        case 'Z' : z++;
                }
            }int temp = Math.max(Math.max(y, c), Math.max(p, z));
            if (max<= temp){
                max= temp;
                maxLine=i;
                maxHang=hang;
            }
        }

        for (int i=0; i<arr.length; i++){
            y=0; c=0; p=0; z=0;
            for (int j=0; j<arr.length; j++){
                    switch (arr[j][i]){
                        case 'Y' : y++; break;
                        case 'C' : c++; break;
                        case 'P' : p++; break;
                        case 'Z' : z++;
                }
            }int temp = Math.max(Math.max(y, c), Math.max(p, z));
            if (max<= temp){
                max= temp;
                maxLine=i;
                maxHang=hang;
            }
        }

        System.out.println(max);


    }
    private static int isPlus(int[][] arr){

    }
    private static int getMax(int[][] arr, )
}
