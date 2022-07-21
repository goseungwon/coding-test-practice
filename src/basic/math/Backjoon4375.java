package basic.math;

import java.io.*;

public class Backjoon4375 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {


        for (int i=0; i<3; i++) {
            int input = Integer.parseInt(br.readLine());
            fun(input);
        }
        System.out.println(sb);
    }

    private static void fun(int input) {
        long num=111;
        while(true){
            if (num%input==0){
                sb.append((int) Math.log10(num)+1+"\n");
                break;
            }else {
                num=num*10+1;
            }
        }
    }
}
