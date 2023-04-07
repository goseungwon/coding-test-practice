package bj.No11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Backjoon18870 {
    static int[] num, num2;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        n = Integer.parseInt(br.readLine());
        num = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        num2 = Arrays.stream(num).distinct().toArray(); //배열의 중복 없에기
        Arrays.sort(num2);                              //정렬

        for (int i=0; i<n; i++){
            sb.append(binary(num[i])+" ");
        }

        System.out.print(sb);
    }


    private static int binary(int num){
        int left = 0;
        int right = num2.length-1;

        while  (left<=right){
            int midindex=(left+right)/2;
            int mid=num2[midindex];

            if (num<mid)
                right=midindex-1;
            else if (num>mid)
                left=midindex+1;
            else return midindex;
        }
        return 0;
    }

}
