package basic.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int yaksu, baesu;

        int input1 = Integer.parseInt(st.nextToken());
        int input2 = Integer.parseInt(st.nextToken());

        if (input1<input2) {
            yaksu = yaksu(input1, input2);
        } else {
            yaksu = yaksu(input2, input1);
        }


        baesu = input1*input2/yaksu;
        System.out.println(yaksu);
        System.out.println(baesu);


    }

    private static int yaksu(int input1, int input2) {
        int output=1;
        int i=2;
            while(i<=input1){
                if (input1%i==0 && input2%i==0){
                    input1=input1/i;
                    input2=input2/i;
                    output=output*i;
                }else{
                    i++;
                }
            }
        return output;
    }


}
