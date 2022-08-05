package basic.BF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon14500 {
    static int[][] arr;
    static int sum; // 총합
    static int x,y;  //입력값
    static int count; // 횟수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
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
                count =0;
                moveEverywhere(i,j, sum);
            }
        }

        System.out.println(sum);
    }



    public static void moveEverywhere(int startY, int startX, int sum){
        while(count<4) {
            moveToRight(startY, startX, sum);
            moveToLeft(startY, startX, sum);
            moveToTop(startY, startX, sum);
            moveToBottom(startY, startX, sum);
            count++;
        }
    }


    //탐색 메서드
    public static int moveToRight(int startY, int startX, int sum) {
        startX++;
        if (startX == x) return 0;
        sum += arr[startY][startX];
        moveEverywhere(startY, startX, count);
        return sum;
    }

    public static int moveToLeft(int startY, int startX, int sum){
        startX--;
        if (startX<0) return 0;
        sum+=arr[startY][startX];
        moveEverywhere(startY,startX,count);
        return sum;
    }

    public static int moveToTop(int startY, int startX, int sum){
        startY++;
        if (startY==y) return 0;
        sum+=arr[startY][startX];
        moveEverywhere(startY,startX,count);
        return sum;
    }

    public static int moveToBottom(int startY, int startX, int sum){
        startY--;
        if (startY<0) return 0;
        sum+=arr[startY][startX];
        moveEverywhere(startY,startX,count);
        return sum;
    }

}
