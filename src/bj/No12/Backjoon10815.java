package bj.No12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Backjoon10815 {
    static int[] input;
    static int n,m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        n= Integer.parseInt(br.readLine());
        input=new int[n];

        String a = br.readLine();
        StringTokenizer st = new StringTokenizer(a);

        int idx = 0;
        while (st.hasMoreTokens()) {
            input[idx] = Integer.parseInt(st.nextToken());
            idx++;
        }

        Arrays.sort(input);

        m = Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine());

        for (int i=0; i<m; i++){
            int num= Integer.parseInt(st.nextToken());
            if (binary(num)){
                sb.append(1+" ");
            }else
                sb.append(0+" ");
        }

        System.out.println(sb);
    }

    private static boolean binary(int num){
        int left=0;
        int right=n-1;

        while  (left<=right){
            int midindex=(left+right)/2;
            int mid=input[midindex];

            if (num<mid)
                right=midindex-1;
            else if (num>mid)
                left=midindex+1;
            else return true;
        }
        return false;
    }
}