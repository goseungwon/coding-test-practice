package doit.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backjoon1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int result = 0;

        String input = br.readLine();
        String[] inputArr = input.split("-");

        for (int i=0; i<inputArr.length; i++){
            if (i==0) result += sum(inputArr[i]);
            else result -= sum(inputArr[i]);
        }
        System.out.println(result);

    }

    static int sum(String a){
        int sum = 0;
        String[] temp = a.split("\\+");
        for (int i=0; i<temp.length; i++){
            sum += Integer.parseInt(temp[i]);
        }
        return sum;
    }
}
