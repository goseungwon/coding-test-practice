package No11;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Backjoon1920 {

    static int[] arr1, arr2;
    static int n,m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        n= Integer.parseInt(br.readLine());
        arr1=new int[n];
        st=new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr1[i]= Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr1);


        m= Integer.parseInt(br.readLine());
        arr2=new int[m];
        st=new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            int n= Integer.parseInt(st.nextToken());
            if (check(n)) {
                bw.write(1+"\n");
            }else bw.write(0+"\n");
        }
        bw.flush();
        bw.close();
    }


    private static boolean check(int n){
        int left =0;
        int right =arr1.length-1;

        while(left<=right){
            int mid=(left+right)/2;
            int midnum=arr1[mid];

            if (n<midnum) right=mid-1;
            else if (n>midnum) left=mid+1;
            else return true;
        }
        return false;
    }
}
