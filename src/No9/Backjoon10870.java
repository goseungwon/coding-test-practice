package No9;

import java.util.Scanner;

public class Backjoon10870 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n =sc.nextInt();

        System.out.println(f(n));
    }

     private static int f(int n){
        if (n>=2)
            return f(n-1)+f(n-2);
        return n;
    }
}
