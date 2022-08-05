package sequence;

import java.io.*;
import java.util.StringTokenizer;

public class Backjoon2477 {

    static int[] arr = new int[6];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());



        int high=0, width=0, smallhigh=0, smallwidth=0;

        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int input1 = Integer.parseInt(st.nextToken());
            int input2 = Integer.parseInt(st.nextToken());
            arr[i]=input2;
            if (input1==1||input1==2){
                if (input2>high) high=input2;
            }else {
                if (input2>width) width=input2;
            }
        }
        int num=findIndex(high);
        int num2=num-1;
        num=num+1;
        if (num==6) num=0;
        if (num2==-1) num2=5;
        smallhigh=Math.abs(arr[num]-arr[num2]);

        num= findIndex(width);
        num2=num-1;
        num=num+1;
        if (num==6) num=0;
        if (num2==-1) num2=5;
        smallwidth=Math.abs(arr[num]-arr[num2]);


//        System.out.println("high = " + high);
//        System.out.println("width = " + width);
//        System.out.println("smallhigh = " + smallhigh);
//        System.out.println("smallwidth = " + smallwidth);
        bw.write(String.valueOf((high*width-smallhigh*smallwidth)*k));


        bw.flush();
        bw.close();
    }

    private static int findIndex(int in){
        for (int i=0; i<arr.length; i++){
            if (in==arr[i]){
                return i;
            }
        }
        return -10;
    }

}

