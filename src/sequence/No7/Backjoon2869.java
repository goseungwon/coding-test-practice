package sequence.No7;

import java.io.*;
import java.util.Scanner;

public class Backjoon2869 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int v = sc.nextInt();

        int count=0;

        if((v-b)%(a-b)>0) count++;
        count+=(v-b)/(a-b);

        System.out.println(count);
    }
}