package sequence.No16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backjoon24416 {
    static int countRecursion = 1;
    static int countDynamic = 0;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        arr = new int[n+1];
//
//        System.out.println("fi = " + fibo(n));
//        System.out.println("dy = " + dynamic(n));
        fibo(n);
        dynamic(n);


        System.out.println(countRecursion + " " + countDynamic);


    }

    public static int fibo(int n){
//        System.out.println("n = " + n);
        if (n==1 || n==2){
            return 1;
        }else{
            countRecursion++;
            return fibo(n-1) + fibo(n-2);
        }
    }

    public static int dynamic(int n){
        arr[1] = 1;
        arr[2] = 2;
        for (int i=3; i<=n; i++){
            arr[i] = arr[i-1] + arr[i-2];
            countDynamic++;
        }
        return arr[n];
    }


}
