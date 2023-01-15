package doit.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Backjoon1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];
        int count = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<num; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for (int i=0; i<arr.length; i++){
            int start = 0;
            int end = arr.length-1;

            while(start < end) {
                if (start == i) { start++; continue; }
                if (end == i) { end--; continue; }
                if (arr[i] == arr[start]+arr[end]) { count++; break;}
                else if (arr[i] > arr[start]+arr[end]) start++;
                else if (arr[i] < arr[start]+arr[end]) end--;
            }
        }
        System.out.println(count);

    }
}
