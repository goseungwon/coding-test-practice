package No10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backjoon1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int i =666;
        while(true){
            if (String.valueOf(i).contains("666")){
                n--;
                if (n==0) {
                    System.out.println(i);
                    break;
                }
            }
            i++;
        }
    }
}
