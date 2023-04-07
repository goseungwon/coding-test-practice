package bj.No7;

import java.util.Scanner;

public class Backjoon2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int a,b;

        a=N/5;

        System.out.println(fun(a,N));


    }
    public static int fun(int a, int N) {
        if (a<0){
            return -1;
        }
        if((N-(a*5))%3==0){
            int b= (N-(a*5))/3;
            return a+b;
        }else{
            return fun(a-1,N);
        }

    }
}




