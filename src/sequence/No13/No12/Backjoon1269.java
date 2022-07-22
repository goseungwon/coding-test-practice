package sequence.No13.No12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Backjoon1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());

        for (int i=0; i<n; i++){
            map.put(Integer.valueOf(st.nextToken()), 1);
        }
        int count=0;

        st = new StringTokenizer(br.readLine());

        for (int i=0; i<m; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (map.containsKey(a)){
                count++;
            }
        }
        System.out.println(n+m-(count*2));
    }
}
