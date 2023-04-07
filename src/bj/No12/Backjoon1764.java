package bj.No12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Backjoon1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();

        for (int i=0; i<n; i++){
            map.put(br.readLine(), 1);
        }
        int count=0;
        String[] arr= new String[m];
        for (int i=0; i<m; i++) {
            String a = br.readLine();
            arr[i] = a;
        }
        Arrays.sort(arr);

        for (int i=0; i<m; i++) {
            if (map.containsKey(arr[i])){
                count++;
                sb.append(arr[i]+"\n");
            }
        }
        System.out.println(count);
        System.out.print(sb);

    }
}
