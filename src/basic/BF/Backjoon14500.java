package basic.BF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Backjoon14500 {
    static int[][] arr;
    static int count=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        arr = new int[y][x];


        //입력
        for (int i=0; i<y; i++){
            st= new StringTokenizer(br.readLine());
            for (int j=0; j<x; j++){
                arr[i][j]= Integer.parseInt(st.nextToken());
            }
        }


        //시작 위치
        for (int i=0; i<y; i++){
            for (int j=0; j<x; j++){
                //탐색 메서드
            }
        }


        System.out.println(count);

    }


    //탐색 메서드
    //public void
}
