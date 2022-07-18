package No12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Backjoon11478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder st;

        Map map = new HashMap();
        int count=0;

        String input = br.readLine();

        String[] arr = input.split("");

        for (int i=0; i< arr.length; i++){
            st = new StringBuilder();
            for (int j=0; j<arr.length-i; j++){
                st.append(arr[i+j]);
                String in = String.valueOf(st);
                if (!map.containsKey(in)){
                    map.put(in, 0);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
