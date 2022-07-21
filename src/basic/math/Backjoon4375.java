package basic.math;

import java.io.*;
import java.util.Scanner;

public class Backjoon4375 {
    public static void main(String[] args) throws IOException {
    //    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while (sc.hasNextInt()) {
            int input=sc.nextInt();
            System.out.println(fun(input));
//            sb.append(fun(input)+"\n");
        }
//        System.out.println(sb);
    }

    private static int fun(int input) {
        long num=1;
        int count=1;

        while(true){
            if (num%input!=0){
                num=(num%input)*10+1;
                count++;
            }else {
                return count;
            }
        }
    }
}
