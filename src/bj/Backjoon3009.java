package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon3009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();

        int[][] arr=new int[3][2];

        for (int i=0; i<3; i++){
            st=new StringTokenizer(br.readLine());
            arr[i][0]= Integer.parseInt(st.nextToken());
            arr[i][1]= Integer.parseInt(st.nextToken());
        }

        if (arr[0][0]==arr[1][0]) sb.append(arr[2][0]+" ");
        else if (arr[0][0]==arr[2][0]) sb.append(arr[1][0]+" ");
        else sb.append(arr[0][0]+" ");

        if (arr[0][1]==arr[1][1]) sb.append(arr[2][1]+" ");
        else if (arr[0][1]==arr[2][1]) sb.append(arr[1][1]+" ");
        else sb.append(arr[0][1]+" ");

        System.out.println(sb);
    }
}
