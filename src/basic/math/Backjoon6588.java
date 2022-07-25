package basic.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backjoon6588 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            int input = Integer.parseInt(br.readLine());
            if (input==0) break;
            int goldbach = goldbach(input);

            if (goldbach >0)
                System.out.println(input+" = "+ goldbach +" + "+(input- goldbach));
            else
                System.out.println("Goldbach's conjecture is wrong.");
        }
    }

    private static int goldbach(int input) {
        for (int i=3; i<input; i+=2){
            if (sosu(i)){
                if (sosu(input-i))
                    return i;
            }
        }return -1;
    }

    private static boolean sosu(int input){
        if (input<=2) return false;
        for (int i=3; i<=Math.sqrt(input); i+=2){
            if (input%i==0)
                return false;
        }
        return true;
    }
}
