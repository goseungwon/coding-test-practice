package basic.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backjoon17425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num= Integer.parseInt(br.readLine());
        int[] arr = new int[10001];
        int max=0;

        for (int j=0; j<num; j++){
            int input=Integer.parseInt(br.readLine());

            if (max<input)
                max=input;

             arr[input]=0;
        }
        getOutput(max,arr);

        System.out.println(sb);
    }

    private static void getOutput(int max, int[] arr) {
        long output=0;
        for (int i = 1; i< Math.sqrt(max); i++){
            output +=i*(max /i);
            if (map.containsKey(i)){            //약수부터 올라가보자자
              sb.append(output+"\n");
            }
        }
    }
}